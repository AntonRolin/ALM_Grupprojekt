package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entities are objects that map to databas tables
@Entity
public class Book {

    @Id    //berättar att detta är nyckel-värdet för entiteten
    @GeneratedValue(strategy=GenerationType.AUTO)  //default, persistence provider bestämmer hur nycklar genereras
    private Long id;
    private String title;
    private String author;

    public Book(){}

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, title='%s', author='%s']",
                id, title, author);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId() {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
