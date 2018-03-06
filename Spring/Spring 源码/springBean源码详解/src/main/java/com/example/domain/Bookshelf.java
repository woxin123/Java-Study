package com.example.domain;

import java.util.List;

public class Bookshelf {
    private List<Book> books;

    public Bookshelf(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
