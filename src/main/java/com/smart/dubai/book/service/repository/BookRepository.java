package com.smart.dubai.book.service.repository;

import com.smart.dubai.book.service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookId(Long bookId);
}
