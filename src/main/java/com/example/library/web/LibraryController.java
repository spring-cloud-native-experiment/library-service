package com.example.library.web;

import com.example.library.domain.Book;
import com.example.library.domain.Catalog;
import com.example.library.service.BookService;
import com.example.library.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/library")
class LibraryController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    List<Catalog> getCatalog() {
        return catalogService.fetchAllCatalogs().stream()
                .map(catalog -> {
                    List<Book> books = catalog.getBooks().stream()
                            .map(Book::getId)
                            .map(bookService::findBookById)
                            .collect(toList());
                    catalog.setBooks(books);
                    return catalog;
                })
                .collect(toList());
    }
}
