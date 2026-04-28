package com.example.bookmanagement.controller;

import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
public class BookController {
    @Autowired
    private BookService service;
    @GetMapping("/")
    public String list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String keyword,
            Model model
    ) {
        Page<Book> bookPage;
        if (keyword != null && !keyword.isEmpty()) {
            bookPage = service.search(keyword, page);
        } else {
            bookPage = service.getAll(page);
        }
        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }
    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("book") Book book,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "form";
        }

        service.save(book);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.getById(id));
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}