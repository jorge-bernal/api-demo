package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    private Author author1, author2, author3;

    @BeforeEach
    void before() {
        author1 = new Author();

        author2 = new Author("Pepe", Arrays.asList(633532277L, 633532288L), new IdentityDocument("NIF", "48903847Q"));

        author3 = new Author();
        author3.setName("Pedro");
        author3.setPhoneNumbers(Arrays.asList(64789534L));

    }

    @Test
    void testAttributes() {
        assertNull(author1.getName());

        assertEquals("Pepe", author2.getName());
        author2.setName("Jose");
        assertEquals("Jose", author2.getName());
        assertTrue(author2.getPhoneNumbers().contains(633532277L));
        assertTrue(author2.getPhoneNumbers().contains(633532288L));
        assertEquals("NIF", author2.getIdentityDocument().getType());
        assertEquals("48903847Q", author2.getIdentityDocument().getNumber());

        assertEquals("Pedro", author3.getName());
        assertTrue(author3.getPhoneNumbers().contains(64789534L));

    }

    @Test
    void builder() {
        author1 = Author.builder().name("Jorge")
                .identityDocument("NIF", "482928374K")
                .phoneNumber(633432266L)
                .phoneNumber(342346839L)
                .build();

        assertEquals("NIF", author1.getIdentityDocument().getType());
        assertEquals("482928374K", author1.getIdentityDocument().getNumber());
        assertEquals("Jorge", author1.getName());
        assertEquals(2, author1.getPhoneNumbers().size());
        assertTrue(author1.getPhoneNumbers().contains(633432266L));
        assertTrue(author1.getPhoneNumbers().contains(342346839L));
    }
}
