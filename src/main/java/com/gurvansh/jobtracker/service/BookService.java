package com.gurvansh.jobtracker.service;

import com.gurvansh.jobtracker.dto.BookDto;
import com.gurvansh.jobtracker.entity.Book;
import com.gurvansh.jobtracker.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Transactional
  public void saveBooks() {
    bookRepository.deleteAll();
    for (int i = 1; i <= 100; i++) {
      Book book = new Book(i, "Book" + i);
      bookRepository.save(book);
      if (i == 11) {
        //throw new NumberFormatException();
      }
    }
  }

  public List<BookDto> getAllBooks() {
    return bookRepository.findAll().stream().map(
            book ->
                    new BookDto(book.getBookId(), book.getBookName())
    ).toList();
  }

  public Optional<Book> getBookById(long id) {
    return bookRepository.findById(id);
  }

}
