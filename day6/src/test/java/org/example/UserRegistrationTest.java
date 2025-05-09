package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    private final UserRegistration registration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() ->
                registration.registerUser("john_doe", "john@example.com", "Password123")
        );
    }

    @Test
    void testEmptyUsername() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("", "john@example.com", "Password123")
        );
        assertEquals("Username cannot be empty.", e.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("john", "johnexample.com", "Password123")
        );
        assertEquals("Invalid email format.", e.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("john", "john@example.com", "pass")
        );
        assertEquals("Password must be at least 8 characters long.", e.getMessage());
    }

    @Test
    void testNullValues() {
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser(null, "john@example.com", "Password123")
        );
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("john", null, "Password123")
        );
        assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("john", "john@example.com", null)
        );
    }
}
