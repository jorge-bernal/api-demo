package me.jorgebernal.api_demo.documents;

import java.util.List;

public class Editorial {

    private final String id;

    private String isbn;

    private String name;

    private List<Author> authorList;

    public Editorial(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public Editorial(String id, String isbn, String name, List<Author> authorList) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.authorList = authorList;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
