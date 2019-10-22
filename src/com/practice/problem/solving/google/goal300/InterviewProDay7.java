package com.practice.problem.solving.google.goal300;

/***
 * Google:
 *
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
 *
 * Example 1:
 * Input: [3, 3, 2, 1, 3, 2, 1]
 * Output: [1, 1, 2, 2, 3, 3, 3]
 */
public class InterviewProDay7 {

    public static void sortInPlace(int[] nums) {
        int writeIndex = 0;
        final int pivot = 1;
        int n = nums.length -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, writeIndex++);
            }
        }
        int zeroesEnd = writeIndex;
        writeIndex = n;
        for (int i = n; i >= zeroesEnd; --i) {
            if (nums[i] > pivot) {
                swap(nums, i, writeIndex--);
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arry = new int[] {3, 3, 2, 1, 3, 2, 1};
        sortInPlace(arry);
        for (int o: arry ) {
            System.out.print(o);
        }
    }

}
