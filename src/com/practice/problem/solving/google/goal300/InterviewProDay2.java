package com.practice.problem.solving.google.goal300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * Microsoft :
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * class Solution:
 *   def lengthOfLongestSubstring(self, s):
 *     # Fill this in.
 *
 * print Solution().lengthOfLongestSubstring('abrkaabcdefghijjxxx')
 * # 10
 *
 * Can you find a solution in linear time?
 */
public class InterviewProDay2 {

    //using window technique

    private static int lengthOfLongestSubstring(String string) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int leftPointer = 0;
        for (int rightPointer  = 0; rightPointer <string.length(); rightPointer++) {
            char rightChar = string.charAt(rightPointer);

            if (map.containsKey(rightChar)) {
                //if present shrink/slide the window
                leftPointer = Math.max(leftPointer, map.get(rightChar) +1);
            }
            map.put(string.charAt(rightPointer), rightPointer);
            maxLen = Math.max(maxLen, rightPointer - leftPointer +1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println("Length of the longest substring: " + lengthOfLongestSubstring("abrkaabcdefghijjxxx"));
    }


}
