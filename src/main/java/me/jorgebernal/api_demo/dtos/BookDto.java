package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.documents.Book;
import me.jorgebernal.api_demo.exceptions.BadRequestException;

public class BookDto {

    private String id;

    private String name;

    private Double price;

    private String authorId;

    public BookDto() {
        //Empty for the framework
    }

    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.price = book.getPrice();
        this.authorId = book.getAuthor().getId();
    }

    public void verify() {
        if (this.name == null || this.price == null || this.authorId == null
                || this.name.isEmpty() || this.price.isInfinite() || this.authorId.isEmpty()) {
            throw new BadRequestException("Incomplete BookDto");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
