package com.example.library.service;

import com.example.library.client.BookServiceClient;
import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookServiceClient client;

    @Autowired
    public BookService(BookServiceClient client) {
        this.client = client;
    }

    public Book findBookById(Long bookId) {
        return client.getBook(bookId);
    }

}
