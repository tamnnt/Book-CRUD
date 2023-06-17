package com.tamnnt.books_manager.controller;

import com.tamnnt.books_manager.model.Book;
import com.tamnnt.books_manager.repository.BookRepository;
import com.tamnnt.books_manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    @RequestMapping("/")
    public String getIndex(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "/add-book";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBook(@RequestParam("id") Long bookId, Model model) {
        Optional<Book> bookEdit = bookService.findBookById(bookId);
        bookEdit.ifPresent(book -> model.addAttribute("book", book));
        return "edit-book";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBook(@RequestParam("id") Long id, RedirectAttributes model) {
        bookService.deleteBook(id);
        model.addFlashAttribute("success", "Xóa thành công!");
        return "redirect:/";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Book book, RedirectAttributes model){
        bookService.saveBook(book);
        model.addFlashAttribute("success", "Thêm mới thành công!");
        return "redirect:/";
    }
    @RequestMapping(value = "saveUpdate", method = RequestMethod.POST)
    public String saveUpdate(@Valid Book book,RedirectAttributes model){
        bookService.saveBook(book);
        model.addFlashAttribute("Success", "Sửa thành công!");
        return "redirect:/ ";
    }


}
