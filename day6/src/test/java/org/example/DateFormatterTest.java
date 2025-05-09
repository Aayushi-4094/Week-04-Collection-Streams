package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    private final DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-12-2023", formatter.formatDate("2023-12-25"));
    }

    @Test
    void testAnotherValidDate() {
        assertEquals("01-01-2000", formatter.formatDate("2000-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid date format", formatter.formatDate("25/12/2023"));
    }

    @Test
    void testInvalidDate() {
        assertEquals("Invalid date format", formatter.formatDate("2023-13-01")); // invalid month
    }

    @Test
    void testEmptyDate() {
        assertEquals("Invalid date format", formatter.formatDate(""));
    }

    @Test
    void testNullDate() {
        assertEquals("Invalid date format", formatter.formatDate(null));
    }
}
