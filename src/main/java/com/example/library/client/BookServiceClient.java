package com.example.library.client;

import com.example.library.domain.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("book-service")
public interface BookServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/books/{bookId}")
    Book getBook(@PathVariable("bookId") Long bookId);
}
