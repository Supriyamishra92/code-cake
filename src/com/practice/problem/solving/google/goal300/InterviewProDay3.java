package com.practice.problem.solving.google.goal300;

import java.io.IOException;


/***
 * TWITTER :
 * A palindrome is a sequence of characters that reads the same backwards and forwards.
 * Given a string, s, find the longest palindromic substring in s.
 *
 * Example:
 * Input: "banana"
 * Output: "anana"
 *
 * Input: "million"
 * Output: "illi"
 */
public class InterviewProDay3 {

    public static String longestPalindromicString(String str) {
        if (str == null || str.length() < 1 ) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCentre(str, i , i);
            int len2 = expandAroundCentre(str, i, i+1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return str.substring(start, end+1);
    }

    private static int expandAroundCentre(String s, int left, int right) {
        int L = left;
        int R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args)  {

            String s = "banana";
            String ret = longestPalindromicString(s);
            String out = (ret);
            System.out.print(out);
        }
}


