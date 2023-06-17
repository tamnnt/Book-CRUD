package com.tamnnt.books_manager.repository;

import com.tamnnt.books_manager.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
