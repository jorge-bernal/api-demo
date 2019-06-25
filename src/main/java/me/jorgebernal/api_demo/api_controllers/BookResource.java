package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.business_controllers.BookBusinessController;
import me.jorgebernal.api_demo.dtos.BookDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = BookResource.BOOKS)
public class BookResource {

    static final String BOOKS = "/books";

    private BookBusinessController bookBusinessController;

    @Autowired
    public BookResource(BookBusinessController bookBusinessController) {
        this.bookBusinessController = bookBusinessController;
    }

    @PostMapping
    public IdDto create(@RequestBody BookDto bookDto) {
        bookDto.verify();
        return this.bookBusinessController.create(bookDto);
    }
}
