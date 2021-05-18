package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.models.*;
import com.example.demo.repositories.*;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    /*
    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Book("Sagan om Ringen", "Tolkien"));
            repository.save(new Book("Sagan om de två tornen", "Tolkien"));
            repository.save(new Book("Sagan om Konungens återkomst", "Tolkien"));
            repository.save(new Book("Ronja Rövardotter", "Astrid Lindgren"));
            repository.save(new Book("Lotta på Bråkmakargatan", "Astrid Lindgren"));

            // fetch all book
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (Book book : repository.findAll()) {
                log.info(book.toString());
            }
            log.info("");

            // fetch an individual book by ID
            Book book = repository.findById(1L);
            log.info("Books found with findById(1L):");
            log.info("--------------------------------");
            log.info(book.toString());
            log.info("");

            // fetch books by title
            log.info("Books found with findByTitle('Sagan om Ringen'):");
            log.info("--------------------------------------------");
            repository.findByTitle("Sagan om Ringen").forEach(bauer -> {
                log.info(bauer.toString());
            });

            log.info("Books found with findByAuthor('Sagan om Ringen'):");
            log.info("--------------------------------------------");
            repository.findByAuthor("Tolkien").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }


     */

}
