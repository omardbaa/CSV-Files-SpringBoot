package com.myproject.backend.entity;

import lombok.*;

import javax.persistence.*;



@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;

    public Role(String name) {
        this.name=name;
    }


}