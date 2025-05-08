package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;
@BeforeEach
    void setup(){
    calc = new Calculator();
}
@Test
    @DisplayName("Addition Test")
    void addTest(){
    assertEquals(5, calc.add(2,3));
}
@Test
    @DisplayName("Subtraction Test")
    void subTest(){
    assertEquals(1,calc.subtract(2,3));
}
@Test
    @DisplayName("Multiply Test")
    void multiplyTest(){
    assertEquals(6, calc.multiply(3,2));
}
@Test
@DisplayName("Division Testcase 1")
    void divideTest1(){
    assertEquals(7, calc.divide(56,8));
}
    @Test
    @DisplayName("Division Testcase 2")
    void divideTest2(){
        assertEquals(0, calc.divide(1,2));
    }
    @Test
    @DisplayName("Division Testcase 3")
    void divideTest3(){
        assertThrows(ArithmeticException.class, () -> calc.divide(10,0));
    }


}