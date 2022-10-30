package com.smart.dubai.book.service;

import com.smart.dubai.book.service.entity.Book;
import com.smart.dubai.book.service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BookserviceApplication {
	public static void main(String[] args) {

		SpringApplication.run(BookserviceApplication.class, args);
	}

}
