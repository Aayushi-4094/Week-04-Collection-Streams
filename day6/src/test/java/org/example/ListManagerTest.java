package org.example;
import org.example.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    ListManager lm;

    @BeforeEach
    void setup() {
        lm = new ListManager();
    }

    @Test
    @DisplayName("Add Element")
    void listAdd() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> expectedList = List.of(1, 2, 3, 4);
        assertEquals(expectedList, lm.addElement(list, 4));
    }

    @Test
    @DisplayName("Remove Element")
    void listRemove() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> expectedList = List.of(1, 2, 4);
        assertEquals(expectedList, lm.removeElement(list, Integer.valueOf(2)));
    }

    @Test
    @DisplayName("Get Size")
    void listSize() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        assertEquals(4, lm.getSize(list));
    }

}
