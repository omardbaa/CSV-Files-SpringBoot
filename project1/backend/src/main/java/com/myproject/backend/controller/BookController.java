package com.myproject.backend.controller;

import com.myproject.backend.service.BookService;
import com.myproject.backend.entity.Book;
import com.myproject.backend.helper.CSVHelper;
import com.myproject.backend.repository.BookRepository;
import com.myproject.backend.responseMessage.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@Tag(name = "books", description = "hhhhh")
public class BookController {

    @Autowired

    private BookRepository bookRepository;
    private BookService bookService;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                bookService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllTutorials() {
        try {
            List<Book> tutorials = bookService.getAllBooks();

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the book", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))}), @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content), @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content), @ApiResponse(responseCode = "403", description = "forbidden", content = @Content), @ApiResponse(responseCode = "404", description = "Book not found", content = @Content)})
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable long id) {
        return bookRepository.findById(id);
//                .orElseThrow(() -> new BookNotFoundException());
    }

    @GetMapping("/")
    public Collection<Book> findBooks() {
        return bookRepository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }
}