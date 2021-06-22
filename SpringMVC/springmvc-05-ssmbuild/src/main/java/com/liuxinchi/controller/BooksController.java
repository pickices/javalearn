package com.liuxinchi.controller;

import com.liuxinchi.dao.BooksService;
import com.liuxinchi.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {

    @Autowired
    @Qualifier("bookSerivce")
    private BooksService booksService;

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/allBook")
    public String queryAllBook(Model model){

        List<Books> bookList = booksService.queryAllBook();
        model.addAttribute("list",bookList);
        return "book/allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model){
        return "book/toAddBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book){
        booksService.addBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toupdateBook(Model model,int id){
        Books book = booksService.queryBookById(id);
        model.addAttribute("book",book);
        return "book/toUpdateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        booksService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int bookID){
        booksService.deleteBook(bookID);
        return "redirect:/book/allBook";
    }
}
