package com.smart.dubai.book.service.model;

import com.smart.dubai.book.service.entity.Book;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutBean {

    private List<BookBean> books;
    private String promotionCode;
}
