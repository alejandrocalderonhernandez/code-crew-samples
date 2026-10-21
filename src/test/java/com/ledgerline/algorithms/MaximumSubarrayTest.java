package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaximumSubarrayTest {

    @Test
    void findsBestRunInMixedValues() {
        assertEquals(6, MaximumSubarray.maxSubarraySum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void usesWholeArrayWhenAllPositive() {
        assertEquals(15, MaximumSubarray.maxSubarraySum(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    void returnsLargestValueWhenAllNegative() {
        assertEquals(-1, MaximumSubarray.maxSubarraySum(new int[] {-3, -1, -7}));
    }

    @Test
    void handlesSingleElement() {
        assertEquals(42, MaximumSubarray.maxSubarraySum(new int[] {42}));
        assertEquals(-42, MaximumSubarray.maxSubarraySum(new int[] {-42}));
    }

    @Test
    void handlesZeros() {
        assertEquals(0, MaximumSubarray.maxSubarraySum(new int[] {0, -1, 0}));
    }

    @Test
    void rejectsNullAndEmpty() {
        assertThrows(IllegalArgumentException.class, () -> MaximumSubarray.maxSubarraySum(null));
        assertThrows(IllegalArgumentException.class,
                () -> MaximumSubarray.maxSubarraySum(new int[0]));
    }
}
