package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.0001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.0001);
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.0001);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.0001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.0001);
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.0001);
    }

    @Test
    void testNegativeCelsiusToFahrenheit() {
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.0001);
    }

    @Test
    void testNegativeFahrenheitToCelsius() {
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.0001);
    }
}
