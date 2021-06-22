package com.liuxinchi.service;

import com.liuxinchi.dao.BooksMapper;
import com.liuxinchi.dao.BooksService;
import com.liuxinchi.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    @Override
    public int deleteBook(int bookID) {
        return booksMapper.deleteBook(bookID);
    }

    @Override
    public int updateBook(Books book) {
        return booksMapper.updateBook(book);
    }

    @Override
    public Books queryBookById(int bookID) {
        return booksMapper.queryBookById(bookID);
    }

    @Override
    public List<Books> queryAllBook() {
        return booksMapper.queryAllBook();
    }
}
