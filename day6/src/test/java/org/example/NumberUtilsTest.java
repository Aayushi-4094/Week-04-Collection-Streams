package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, -8, 0})  // Even numbers
    void testIsEven_WithEvenNumbers_ReturnsTrue(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, -9})  // Odd numbers
    void testIsEven_WithOddNumbers_ReturnsFalse(int number) {
        assertFalse(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})  // Mixed numbers
    void testIsEven_WithMixedNumbers(int number) {
        boolean expected = number % 2 == 0;
        assertEquals(expected, NumberUtils.isEven(number));
    }
}