package com.gurvansh.jobtracker.controller;

import com.gurvansh.jobtracker.dto.BookDto;
import com.gurvansh.jobtracker.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
  BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public List<BookDto> getBooks() {
    bookService.saveBooks();
    return bookService.getAllBooks();
  }
}
