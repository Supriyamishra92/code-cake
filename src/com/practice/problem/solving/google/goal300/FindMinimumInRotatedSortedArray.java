package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Good Clarifying questions :
 *
 * Does the array contain negatives : NO
 * Does the array contain duplicates NO
 * Is there any pattern in array if looks patterned clarify : NO pattern only natural numbers
 * Missing numbers can be possible : Yes
 * Can array be empty : No
 *
 *
 * Approach :
 *
 * the array is sorted beforehand and pivot is unknown meaning we have some partial sorted array
 *
 * Efficient solution to sort or to get the minimum in the two parted sorted array.
 * 12345678
 *
 */
 public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] numberArray) {
        int minNum = numberArray[0];

        if (numberArray.length ==1){
            return numberArray[0];
        }
        for (int i = 0; i < numberArray.length - 1; i++) {
         minNum = Math.min(minNum, numberArray[i]);

        }
        return minNum;

    }
}
  class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new FindMinimumInRotatedSortedArray().findMin(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

