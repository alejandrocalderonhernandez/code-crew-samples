package com.ledgerline.algorithms;

public final class ReverseString {

    public static String reverse(String text) {
        if (text == null) {
            return null;
        }
        char[] chars = text.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temporary = chars[left];
            chars[left] = chars[right];
            chars[right] = temporary;
            left++;
            right--;
        }
        return new String(chars);
    }
}
