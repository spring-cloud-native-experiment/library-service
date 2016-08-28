package com.example.library.service;

import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    private RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Book findBookById(Long bookId) {
        return restTemplate.getForObject("http://localhost:8081/books/" + bookId, Book.class);
    }

}
