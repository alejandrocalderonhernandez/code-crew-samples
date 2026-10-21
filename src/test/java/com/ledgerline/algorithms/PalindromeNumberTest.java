package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PalindromeNumberTest {

    @Test
    void acceptsPalindromes() {
        assertTrue(PalindromeNumber.isPalindrome(121));
        assertTrue(PalindromeNumber.isPalindrome(1221));
        assertTrue(PalindromeNumber.isPalindrome(1234321));
    }

    @Test
    void acceptsZeroAndSingleDigits() {
        assertTrue(PalindromeNumber.isPalindrome(0));
        assertTrue(PalindromeNumber.isPalindrome(7));
    }

    @Test
    void rejectsNonPalindromes() {
        assertFalse(PalindromeNumber.isPalindrome(123));
        assertFalse(PalindromeNumber.isPalindrome(10));
        assertFalse(PalindromeNumber.isPalindrome(1001002));
    }

    @Test
    void rejectsNegativeNumbers() {
        assertFalse(PalindromeNumber.isPalindrome(-121));
        assertFalse(PalindromeNumber.isPalindrome(Integer.MIN_VALUE));
    }

    @Test
    void handlesLargeValuesWithoutOverflow() {
        assertFalse(PalindromeNumber.isPalindrome(Integer.MAX_VALUE));
        assertTrue(PalindromeNumber.isPalindrome(2147447412));
    }
}
