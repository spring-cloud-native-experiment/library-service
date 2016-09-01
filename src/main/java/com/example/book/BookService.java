package com.example.book;

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
