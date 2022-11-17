package com.myproject.backend.entity;

import lombok.*;

import javax.persistence.*;

public

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")

class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private  String title;




}
