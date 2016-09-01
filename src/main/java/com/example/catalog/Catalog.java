package com.example.catalog;

import com.example.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Catalog {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private List<Book> books;
}