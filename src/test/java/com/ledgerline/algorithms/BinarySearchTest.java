package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private static final int[] VALUES = {-8, -2, 0, 3, 7, 11, 20};

    @Test
    void findsEveryElement() {
        for (int i = 0; i < VALUES.length; i++) {
            assertEquals(i, BinarySearch.indexOf(VALUES, VALUES[i]));
        }
    }

    @Test
    void returnsMinusOneWhenAbsent() {
        assertEquals(-1, BinarySearch.indexOf(VALUES, 5));
        assertEquals(-1, BinarySearch.indexOf(VALUES, -100));
        assertEquals(-1, BinarySearch.indexOf(VALUES, 100));
    }

    @Test
    void handlesSingleElement() {
        assertEquals(0, BinarySearch.indexOf(new int[] {4}, 4));
        assertEquals(-1, BinarySearch.indexOf(new int[] {4}, 5));
    }

    @Test
    void handlesEmptyAndNull() {
        assertEquals(-1, BinarySearch.indexOf(new int[0], 1));
        assertEquals(-1, BinarySearch.indexOf(null, 1));
    }

    @Test
    void findsOneOfTheDuplicates() {
        int[] values = {1, 2, 2, 2, 3};
        assertEquals(2, values[BinarySearch.indexOf(values, 2)]);
    }

    @Test
    void handlesExtremeIntValues() {
        int[] values = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertEquals(0, BinarySearch.indexOf(values, Integer.MIN_VALUE));
        assertEquals(2, BinarySearch.indexOf(values, Integer.MAX_VALUE));
    }
}
