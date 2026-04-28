package com.example.bookmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title không được để trống")
    @Size(min = 5, max = 150, message = "Title phải từ 5-150 ký tự")
    private String title;

    @NotBlank(message = "Author không được để trống")
    private String author;

    @NotNull(message = "Date không được để trống")
    @PastOrPresent(message = "Date không được ở tương lai")
    private LocalDate date;
}