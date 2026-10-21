package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void findsPairInMiddleOfArray() {
        assertArrayEquals(new int[] {1, 3}, TwoSum.twoSum(new int[] {5, 2, 9, 7}, 9));
    }

    @Test
    void findsPairAtStart() {
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {3, 4, 10}, 7));
    }

    @Test
    void handlesNegativeValues() {
        assertArrayEquals(new int[] {0, 2}, TwoSum.twoSum(new int[] {-4, 8, 1}, -3));
    }

    @Test
    void handlesDuplicateValues() {
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {6, 6}, 12));
    }

    @Test
    void doesNotReuseTheSameElement() {
        assertArrayEquals(new int[0], TwoSum.twoSum(new int[] {6, 1}, 12));
    }

    @Test
    void returnsEmptyArrayWhenNoPairExists() {
        assertArrayEquals(new int[0], TwoSum.twoSum(new int[] {1, 2, 3}, 100));
    }

    @Test
    void returnsEmptyArrayForEmptyOrNullInput() {
        assertArrayEquals(new int[0], TwoSum.twoSum(new int[0], 5));
        assertArrayEquals(new int[0], TwoSum.twoSum(new int[] {5}, 5));
        assertArrayEquals(new int[0], TwoSum.twoSum(null, 5));
    }
}
