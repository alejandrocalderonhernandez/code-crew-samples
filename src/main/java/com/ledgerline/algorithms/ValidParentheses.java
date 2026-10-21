package com.ledgerline.algorithms;

import java.util.ArrayDeque;

public final class ValidParentheses {

    public static boolean isValid(String text) {
        if (text == null) {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                boolean matches = (current == ')' && open == '(')
                        || (current == ']' && open == '[')
                        || (current == '}' && open == '{');
                if (!matches) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
