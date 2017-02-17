package com.ot.algorithms.date20170217validParantheses;

import java.util.HashMap;
import java.util.Stack;

public class ParanthesesValidator {

    private static HashMap<Character, Character> openChars = new HashMap<>();

    private static HashMap<Character, Character> closedChars = new HashMap<>();

    static {
        openChars.put('(', ')');
        openChars.put('{', '}');
        openChars.put('[', ']');

        closedChars.put(')', '(');
        closedChars.put('}', '{');
        closedChars.put(']', '[');
    }

    public boolean validate(String input) {
        if (input == null || input.trim().length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int index = 0; index < input.length(); index++) {
            Character current = input.charAt(index);
            if (isOpenChar(current)) {
                stack.push(current);
            } else if (isClosedChar(current)) {
                if (stack.size() == 0) {
                    return false;
                }
                Character previous = stack.pop();
                if (isClosedChar(previous)) {
                    return false;
                }
                if (previous != getMatchingOpenChar(current)) {
                    return false;
                }
            } else {
                return false;
            }

        }

        return stack.size() == 0;

    }

    private boolean isOpenChar(Character c) {
        return openChars.containsKey(c);
    }

    private boolean isClosedChar(Character c) {
        return closedChars.containsKey(c);
    }

    private Character getMatchingOpenChar(Character c) {
        return closedChars.get(c);
    }
}


public class ParanthesesValidatorTest {

    @Test
    public void validateTest() {
        ParanthesesValidator validator = new ParanthesesValidator();
        assertTrue(validator.validate("()"));
        assertTrue(validator.validate("()[]{}"));
        assertFalse(validator.validate("([)]"));
        assertFalse(validator.validate("("));
        assertFalse(validator.validate("(("));
        assertFalse(validator.validate("]"));
        assertFalse(validator.validate("]]"));
        assertFalse(validator.validate("{{}"));
        assertFalse(validator.validate("{a"));
    }
}