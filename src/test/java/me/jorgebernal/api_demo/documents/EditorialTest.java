package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorialTest {

    private Editorial editorial;

    @Test
    void idConstructorAndSetters() {
        editorial = new Editorial("ED1", "978-3-16-148410-0");
        editorial.setName("Star Editorial");

        assertEquals("ED1", editorial.getId());
        assertEquals("978-3-16-148410-0", editorial.getIsbn());
    }
}
