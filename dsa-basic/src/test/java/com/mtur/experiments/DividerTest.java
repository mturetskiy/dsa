package com.mtur.experiments;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DividerTest {
    @Test
    void testDivideHappyPath() {
        Divider divider = new Divider();
        assertEquals(3, divider.divide(7, 2));
        assertEquals(3, divider.divide(6, 2));
        assertEquals(61, divider.divide(734, 12));
        assertEquals(1024, divider.divide(1024, 1));
    }

    @Test
    void testDivideFast() {
        Divider divider = new Divider();
        assertEquals(341, divider.divideFast(1024, 3));
        assertEquals(5, divider.divideFast(15, 3));
        assertEquals(4, divider.divideFast(9, 2));
        assertEquals(5, divider.divideFast(63, 12));
        assertEquals(3, divider.divideFast(10, 3));
        assertEquals(-2, divider.divideFast(7, -3));
    }
}