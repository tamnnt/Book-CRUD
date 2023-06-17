package com.tamnnt.books_manager.service;

import com.tamnnt.books_manager.model.Book;
import com.tamnnt.books_manager.repository.BookRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }

}
