package me.jorgebernal.api_demo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    @Id
    private String id;

    private String name;

    private Double price;

    @DBRef
    private Author author;

    public Book() {
    }

    public Book(String name, Double price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getId() {
        return id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
