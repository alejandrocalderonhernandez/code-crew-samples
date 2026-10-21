package com.ledgerline.algorithms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    @Test
    void acceptsSimplePairs() {
        assertTrue(ValidParentheses.isValid("()"));
        assertTrue(ValidParentheses.isValid("()[]{}"));
    }

    @Test
    void acceptsNestedPairs() {
        assertTrue(ValidParentheses.isValid("{[()()]}"));
    }

    @Test
    void ignoresOtherCharacters() {
        assertTrue(ValidParentheses.isValid("total = (a + b) * [c - {d}]"));
        assertTrue(ValidParentheses.isValid("no brackets"));
    }

    @Test
    void acceptsEmptyText() {
        assertTrue(ValidParentheses.isValid(""));
    }

    @Test
    void rejectsWrongOrder() {
        assertFalse(ValidParentheses.isValid("(]"));
        assertFalse(ValidParentheses.isValid("([)]"));
    }

    @Test
    void rejectsUnclosedOrUnopened() {
        assertFalse(ValidParentheses.isValid("(("));
        assertFalse(ValidParentheses.isValid("())"));
        assertFalse(ValidParentheses.isValid("}"));
    }

    @Test
    void rejectsNull() {
        assertFalse(ValidParentheses.isValid(null));
    }
}
