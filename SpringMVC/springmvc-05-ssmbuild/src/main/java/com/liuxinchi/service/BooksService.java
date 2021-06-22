package com.liuxinchi.dao;

import com.liuxinchi.pojo.Books;

import java.util.List;

public interface BooksService {
    int addBook(Books book);
    int deleteBook(int bookID);
    int updateBook(Books book);
    Books queryBookById(int bookID);
    List<Books> queryAllBook();

}
