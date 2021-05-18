package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.*;


public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByTitleAndAuthor(String title, String author);
    Book findById(long id);

}



