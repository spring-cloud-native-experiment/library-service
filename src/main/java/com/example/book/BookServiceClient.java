package com.example.book;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("book-service")
interface BookServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/books/{bookId}")
    Book getBook(@PathVariable("bookId") Long bookId);
}
