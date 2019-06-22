package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdentityDocumentTest {

    private IdentityDocument identityDocument;

    @BeforeEach
    void before() {
        identityDocument = new IdentityDocument("NIF", "39182948K");
    }

    @Test
    void constructor() {
        assertEquals("NIF", identityDocument.getType());
        assertEquals("39182948K", identityDocument.getNumber());
    }

    @Test
    void change() {
        identityDocument.change("OTHER", "x12313124LL");

        assertEquals("OTHER", identityDocument.getType());
        assertEquals("x12313124LL", identityDocument.getNumber());
    }
}
