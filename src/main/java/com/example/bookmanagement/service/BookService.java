package com.example.bookmanagement.service;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
@Service
public class BookService {
    @Autowired
    private BookRepository repo;
    public Page<Book> getAll(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findAll(pageable);
    }
    public Page<Book> search(String keyword, int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
                keyword, keyword, pageable
        );
    }
    public void save(Book b) {
        repo.save(b);
    }
    public Book getById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}