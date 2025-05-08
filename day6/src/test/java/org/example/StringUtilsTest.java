package org.example;

        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils sut;

    @BeforeEach
    void setup() {
        sut = new StringUtils();
    }

    @Test
    @DisplayName("Reverse of Palindrome")
    void testReverseOfPalindrome() {
        assertEquals("arora", sut.reverse("arora"), "Reverse of 'arora' should be 'arora'");
    }

    @Test
    @DisplayName("Reverse of Non-Palindrome")
    void testReverseOfNonPalindrome() {
        assertEquals("aayushi", sut.reverse("ihsuyaa"), "Reverse of 'ihsuyaa' should be 'aayushi'");
    }

    @Test
    @DisplayName("Reverse of Same String")
    void testReverseOfSameString() {
        assertEquals("aayushi", sut.reverse("ihsuyaa"));
    }

    @Test
    @DisplayName("Palindrome Test")
    void testPalindrome() {
        assertTrue(sut.isPalindrome("arora"), "arora");
    }

    @Test
    @DisplayName("Non-Palindrome Test")
    void testNonPalindrome() {
        assertFalse(sut.isPalindrome("aayushi"), "'aayushi' should not be a palindrome");
    }

    @Test
    @DisplayName("To Uppercase Test")
    void testToUpperCase() {
        assertEquals("AAYUSHI", sut.toUpperCase("aayushi"), "'aayushi' in uppercase should be 'AAYUSHI'");
    }
}


