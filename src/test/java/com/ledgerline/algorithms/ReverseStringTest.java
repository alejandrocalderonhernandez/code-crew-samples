package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ReverseStringTest {

    @Test
    void reversesEvenLengthText() {
        assertEquals("dcba", ReverseString.reverse("abcd"));
    }

    @Test
    void reversesOddLengthText() {
        assertEquals("regdel", ReverseString.reverse("ledger"));
        assertEquals("cba", ReverseString.reverse("abc"));
    }

    @Test
    void keepsSpacesAndPunctuation() {
        assertEquals("!dlrow ,olleh", ReverseString.reverse("hello, world!"));
    }

    @Test
    void handlesEmptyAndSingleCharacter() {
        assertEquals("", ReverseString.reverse(""));
        assertEquals("x", ReverseString.reverse("x"));
    }

    @Test
    void returnsNullForNull() {
        assertNull(ReverseString.reverse(null));
    }
}
