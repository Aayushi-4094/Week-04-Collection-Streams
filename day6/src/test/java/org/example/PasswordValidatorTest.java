package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("S1hort"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("lowercase1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("NoDigitsHere"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void testExactly8CharsValid() {
        assertTrue(validator.isValid("Abcdef1G"));
    }
}
