package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private Event event;

    @Test
    void idConstructorAndSetters() {
        event = new Event("EV1");
        event.setLocalDateTime(LocalDateTime.of(2019, Month.MAY, 2, 12, 0, 0));
        event.setAuthorList(Arrays.asList(Author.builder().name("Jorge").build(), new Author()));
        event.setUnderage(true);
        event.setBuild(true);

        assertEquals("EV1", event.getId());
        assertEquals(LocalDateTime.of(2019, Month.MAY, 2, 12, 0, 0), event.getLocalDateTime());
        assertTrue(event.getUnderage());
        assertTrue(event.getBuild());
    }

}
