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
                book1.setTitle("Thế Giới Của Những Chú Chip Thông Minh");
                book1.setAuthor("John Smith");
                book1.setDate(LocalDate.of(2020, 5, 15));
                Book book2 = new Book();
                book2.setTitle("Java Programming - Hướng Dẫn Toàn Diện");
                book2.setAuthor("James Gosling");
                book2.setDate(LocalDate.of(2019, 3, 20));

                Book book3 = new Book();
                book3.setTitle("Spring Framework Mastery");
                book3.setAuthor("Rod Johnson");
                book3.setDate(LocalDate.of(2021, 7, 10));
                Book book4 = new Book();
                book4.setTitle("Lập Trình Web Hiện Đại");
                book4.setAuthor("Nguyễn Hữu Vinh");
                book4.setDate(LocalDate.of(2022, 1, 5));
                Book book5 = new Book();
                book5.setTitle("Clean Code - Mã Sạch");
                book5.setAuthor("Robert Martin");
                book5.setDate(LocalDate.of(2018, 11, 30));
                Book book6 = new Book();
                book6.setTitle("Design Patterns in Java");
                book6.setAuthor("Gang of Four");
                book6.setDate(LocalDate.of(2017, 9, 12));
                Book book7 = new Book();
                book7.setTitle("Hiệu Suất Ứng Dụng Java");
                book7.setAuthor("Scott Oaks");
                book7.setDate(LocalDate.of(2020, 6, 25));
                Book book8 = new Book();
                book8.setTitle("RESTful Web Services");
                book8.setAuthor("Leonard Richardson");
                book8.setDate(LocalDate.of(2019, 8, 14));
                Book book9 = new Book();
                book9.setTitle("Microservices Architecture");
                book9.setAuthor("Sam Newman");
                book9.setDate(LocalDate.of(2021, 2, 18));
                Book book10 = new Book();
                book10.setTitle("Database Design Fundamentals");
                book10.setAuthor("Lê Minh Tuấn");
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
                System.out.println("✓ Đã thêm 10 cuốn sách vào database");
            }
        };
    }

}
