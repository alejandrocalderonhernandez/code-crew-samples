package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void buildsFirstFifteenEntries() {
        List<String> expected = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
                "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        assertEquals(expected, FizzBuzz.fizzBuzz(15));
    }

    @Test
    void returnsSingleEntryForOne() {
        assertEquals(List.of("1"), FizzBuzz.fizzBuzz(1));
    }

    @Test
    void hasExactlyNEntries() {
        List<String> result = FizzBuzz.fizzBuzz(100);
        assertEquals(100, result.size());
        assertEquals("Buzz", result.get(99));
        assertEquals("FizzBuzz", result.get(89));
    }

    @Test
    void rejectsZeroAndNegative() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
    }
}
