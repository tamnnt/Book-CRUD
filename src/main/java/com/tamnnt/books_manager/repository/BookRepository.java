package com.tamnnt.books_manager.repository;

import com.tamnnt.books_manager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
