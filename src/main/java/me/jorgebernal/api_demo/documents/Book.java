package me.jorgebernal.api_demo.documents;

public class Book {

    private final String id;

    private String name;

    private Double price;

    private Author author;

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String name, Double price, Author author) {
        this.id = id;
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
