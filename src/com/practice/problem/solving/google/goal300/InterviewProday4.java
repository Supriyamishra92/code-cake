package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * UBER :
 *
 * Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 * - Note that an empty string is also considered valid.
 *
 * Example:
 * Input: "((()))"
 * Output: True
 *
 * Input: "[()]{}"
 * Output: True
 *
 * Input: "({[)]"
 * Output: False
 */
public class InterviewProday4 {


    public static boolean isValidParanthesis(String string) {

        Map<Character, Character> mapping  = new HashMap<>();
        mapping.put(')','(');
        mapping.put('}','{');
        mapping.put(']','[');


        if (string.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (mapping.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mapping.get(c)) {
                    return false;
                }

            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {


                String s = "[()]{}";

                boolean ret = isValidParanthesis(s);

                System.out.print(ret);
    }
}
