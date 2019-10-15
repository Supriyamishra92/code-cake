package com.practice.problem.solving.google.goal300;

/***
 * AirBNB:
 *
 * Given a sorted array, A, with possibly duplicated elements,
 * find the indices of the first and last occurrences of a target element, x.
 * Return -1 if the target is not found.
 *
 * Example:
 * Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
 * Output: [6,8]
 *
 * Input: A = [100, 150, 150, 153], target = 150
 * Output: [1,2]
 *
 * Input: A = [1,2,3,4,5,6,10], target = 9
 * Output: [-1, -1]
 */
public class InterviewProDay5 {

    private static int[] duplicateIndices(int[] array, int target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < array.length; i++) {

            if (array[i] == target) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] array = new int[] {100, 150, 150, 153};
        int[] arr = new int[] {1,3,3,5,7,8,9,9,9,15};
        int t = 9;
        int[] res = duplicateIndices(arr, t);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
        int target = 150;
        res = duplicateIndices(array, target);

        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }
}
