package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;

    @BeforeEach
    void before() {
        book = new Book("A1");
        book.setAuthor(Author.builder().name("Jorge").build());
        book.setName("The Name of the Wind");
        book.setPrice(29.99);
    }

    @Test
    void idConstructorAndSetters() {
        assertEquals("Jorge", book.getAuthor().getName());
        assertEquals("The Name of the Wind", book.getName());
        assertEquals(new Double(29.99), book.getPrice());
    }

    @Test
    void fullConstructor() {
        book = new Book("A2", "A Wise Man Fear", 39.99, new Author());
        assertEquals("A2", book.getId());
        assertEquals("A Wise Man Fear", book.getName());
        assertEquals(new Double(39.99), book.getPrice());
    }
}
