package com.example.bookmanagement;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BookmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanagementApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(BookRepository bookRepository) {
        return args -> {
            if (bookRepository.count() == 0) {
                Book book1 = new Book();
                book1.setTitle("Đắc tâm nhân");
                book1.setAuthor("Quydz");
                book1.setDate(LocalDate.of(2020, 5, 15));
                Book book2 = new Book();
                book2.setTitle("HihiHaha");
                book2.setAuthor("Quydz2");
                book2.setDate(LocalDate.of(2019, 3, 20));
                Book book3 = new Book();
                book3.setTitle("Truyện ma 3 giờ sáng");
                book3.setAuthor("Quydz3");
                book3.setDate(LocalDate.of(2021, 7, 10));
                Book book4 = new Book();
                book4.setTitle("Những cuộc phưu lưu của cá xấu");
                book4.setAuthor("Quydz4");
                book4.setDate(LocalDate.of(2022, 1, 5));
                Book book5 = new Book();
                book5.setTitle("JAVA-WEB-APPLICATION");
                book5.setAuthor("Quydz5");
                book5.setDate(LocalDate.of(2018, 11, 30));
                Book book6 = new Book();
                book6.setTitle("HUHUHEHE");
                book6.setAuthor("Quydz6");
                book6.setDate(LocalDate.of(2017, 9, 12));
                Book book7 = new Book();
                book7.setTitle("ALABATRAP");
                book7.setAuthor("Quydz7");
                book7.setDate(LocalDate.of(2020, 6, 25));
                Book book8 = new Book();
                book8.setTitle("PRESS F TO PRAY");
                book8.setAuthor("Quydz8");
                book8.setDate(LocalDate.of(2019, 8, 14));
                Book book9 = new Book();
                book9.setTitle("HOLY COW");
                book9.setAuthor("Quydz9");
                book9.setDate(LocalDate.of(2021, 2, 18));
                Book book10 = new Book();
                book10.setTitle("MY SECRET GAY BOY FRIEND");
                book10.setAuthor("Quydz10");
                book10.setDate(LocalDate.of(2022, 4, 8));
                bookRepository.save(book1);
                bookRepository.save(book2);
                bookRepository.save(book3);
                bookRepository.save(book4);
                bookRepository.save(book5);
                bookRepository.save(book6);
                bookRepository.save(book7);
                bookRepository.save(book8);
                bookRepository.save(book9);
                bookRepository.save(book10);
            }
        };
    }

}
