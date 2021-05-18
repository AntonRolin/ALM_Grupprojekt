package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // This means that this class is a Controller
@RequestMapping(path="/books") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called bookRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BookRepository bookRepository;

    //för att posta från kommandoraden: curl localhost:8080/demo/add -d title=First -d author=SomeGuy
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUserByPost (@RequestParam String title
            , @RequestParam String author) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Book n = new Book(title, author);
        bookRepository.save(n);
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the books
        return bookRepository.findAll();
    }

    @GetMapping(path="/book")
    public @ResponseBody Iterable<Book> getBookByTitle (@RequestParam (required = false) String title,
                                                        @RequestParam (required = false) String author) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if (title != null && author != null){
            return bookRepository.findByTitleAndAuthor(title, author);
        }
        else if (title != null){
            return bookRepository.findByTitle(title);
        }
        else if (author != null){
            return bookRepository.findByAuthor(author);
        }
        return null;
    }

}