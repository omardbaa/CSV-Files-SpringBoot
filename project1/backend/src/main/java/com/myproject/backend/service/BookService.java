package com.myproject.backend.service;

import com.myproject.backend.entity.Book;
import com.myproject.backend.helper.CSVHelper;
import com.myproject.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class BookService {


    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(MultipartFile file) {
        try {
            List<Book> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            bookRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
