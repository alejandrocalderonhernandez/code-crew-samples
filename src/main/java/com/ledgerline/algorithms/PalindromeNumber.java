package com.ledgerline.algorithms;

public final class PalindromeNumber {

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        int remaining = number;
        long reversed = 0;
        while (remaining > 0) {
            int lastDigit = remaining % 10;
            reversed = reversed * 10 + lastDigit;
            remaining = remaining / 10;
        }
        return reversed == number;
    }
}
