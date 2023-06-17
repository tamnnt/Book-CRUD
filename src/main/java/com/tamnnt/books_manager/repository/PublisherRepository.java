package com.tamnnt.books_manager.repository;

import com.tamnnt.books_manager.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
