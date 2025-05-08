package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {
ExceptionHandling exph;
    @BeforeEach
    void setup(){
        exph = new ExceptionHandling();
    }
    @Test
    @DisplayName("Division Testcase 1")
    void divideTest1(){
        assertEquals(7, exph.divide(56,8));
    }
    @Test
    @DisplayName("Division Testcase 2")
    void divideTest2(){
        assertEquals(0, exph.divide(1,2));
    }
    @Test
    @DisplayName("Division Testcase 3")
    void divideTest3(){
        assertThrows(ArithmeticException.class, () -> exph.divide(10,0));
    }
}