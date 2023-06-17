package com.tamnnt.books_manager.repository;

import com.tamnnt.books_manager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
