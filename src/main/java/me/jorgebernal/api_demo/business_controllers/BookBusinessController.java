package me.jorgebernal.api_demo.business_controllers;

import me.jorgebernal.api_demo.daos.AuthorDao;
import me.jorgebernal.api_demo.daos.BookDao;
import me.jorgebernal.api_demo.documents.Author;
import me.jorgebernal.api_demo.documents.Book;
import me.jorgebernal.api_demo.dtos.BookDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import me.jorgebernal.api_demo.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookBusinessController {

    private BookDao bookDao;

    private AuthorDao authorDao;


    @Autowired
    public BookBusinessController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    public IdDto create(BookDto bookDto) {
        Author author = authorDao.findById(bookDto.getAuthorId()).orElseThrow(() -> new NotFoundException("Author doesn't exist"));
        Book book = new Book(bookDto.getName(), bookDto.getPrice(), author);
        bookDao.save(book);
        return new IdDto(book.getId());
    }


}
