package com.smart.dubai.book.service.controller;

import com.google.gson.Gson;
import com.smart.dubai.book.service.entity.Book;
import com.smart.dubai.book.service.model.BookTypes;
import com.smart.dubai.book.service.model.CheckoutBean;
import com.smart.dubai.book.service.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/")
    public ResponseEntity<String> saveBook(@RequestBody Book book){
        log.info("BookController.saveBook starts here:");
        Book isbookSaved = null;
        if(BookTypeValidation(book.getType())){
            return ResponseEntity.badRequest()
                    .body("Bad request:: Currently supported Books are 'FICTION' and 'COMIC'");
        }
        if(null != book)
            isbookSaved = service.saveBook(book);
        return ResponseEntity.ok()
                .body(isbookSaved !=null ? "Book has been saved" : "Bad request");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findBookById(@PathVariable("id") Long bookId){
        log.info("BookController.findBookById starts here:");
        Book book = null;
        Gson gson = new Gson();
        if(null != bookId && 0 != bookId)
            book=service.findBookById(bookId);

        return ResponseEntity.ok()
                .body(book !=null ? gson.toJson(book): "Bad request");
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getBooks(){
        log.info("BookController.findBookById starts here:");
        List<Book> books =service.findAll();

        return ResponseEntity.ok()
                .body(books);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        log.info("BookController.updateBook starts here:");
        Book isbookSaved = null;
        if(null != book)
            isbookSaved = service.updateBook(book);
        return ResponseEntity.ok()
                .body(isbookSaved !=null ? "Book has been updated" : "Bad request");
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkoutBooks(@RequestBody CheckoutBean checkoutBean){
        log.info("BookController.checkoutBooks starts here:");
        Double price = null;
        if(null != checkoutBean && checkoutBean.getBooks().size() > 0);
            price = service.checkoutBooks(checkoutBean);
        return ResponseEntity.ok()
                .body(price !=null ? "Total Price after discount : "+ price : "Bad request");
    }

    private boolean BookTypeValidation(String type){
        try{
            BookTypes.valueOf(type);
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
