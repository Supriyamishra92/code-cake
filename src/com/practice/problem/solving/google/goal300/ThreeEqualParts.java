package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.
 * If it is possible, return any [i, j] with i+1 < j, such that:
 *
 * A[0], A[1], ..., A[i] is the first part;
 * A[i+1], A[i+2], ..., A[j-1] is the second part, and
 * A[j], A[j+1], ..., A[A.length - 1] is the third part.
 * All three parts have equal binary value.
 * If it is not possible, return [-1, -1].
 *
 * Note that the entire part is used when considering what binary value it represents.
 * For example, [1,1,0] represents 6 in decimal, not 3.
 * Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.

 * Example 1:
 * Input: [1,0,1,0,1]
 * Output: [0,3]
 *
 * Approach
 * We need to have 3 arrays with binary number represented by them should be all equal.
 * We know that leading '0'(zero) in binary doesn't add value to binary number, but trailiing zero's do.
 * So, if we could first count the trailing zeros in the incoming input first. Then we can try to find 2 other arrays
 * with same number of trailing zeros. If it's not possible to find such 3 arrays, then we can't find solution.
 * Also, since we need to slice array into 3 parts, then we need to make sure the incoming arrays contains '1' which are divisible by 3.
 *
 * Algorithm
 * 1.Get the SUM of the array. If the SUM is not divisible by 3 then we can blindly return [-1,-1] as answer. Otherwise go to step2
 * 2.If sum is 0 then we can split array in many possible ways, we can use [0,A.length-1] as answer. You can hardcode some other value as well, it should work. Otherwise, go to step3
 * 3.Find the trailing zero's in the input. Lets call it trailingZeros. targetSum is equal to SUM/3
 * 4.Now lets iterate through the input and find the 2 split where the running sum of the split array is equal to targetSum.
 * We know there are count of trailingZeros at the end. So, after we find the targetSum store the index with trailingZeros count added. Why we add trailingZeros count to the first and second split of the array?
 * Reason: If the last array contains those many trailing zeros then other 2 also must contain those, failing to do so means we cannot split the array into 3 parts.
 * Once we find the 2 splits. We can iterate through the split and check whether splitSum matches targetSum?. Return the [-1,-1] when there is no match.
 * Last part of the algo: We found 3 arrays with equals sum, but it's possible that individual binary number formed by split array may not match.
 * So, lets check the individual bits do they match. Why we need to match?
 * Reason: Matching them gives a clear indication that binary number formed by 3 are actually equal.
 *
 * Runtime Complexity is O(N) - N is length of input array.
 * Space Complexity is O(1) - Constant.
 */

public class ThreeEqualParts {

    private static int[] findPartitionIndex(int[] binArr)
    {
        if (binArr == null || binArr.length < 3)
        {
          return new int[] {-1,-1};
        }

        int totalOne = 0;
        for (int i = 0; i <binArr.length; i++) {

            if (binArr[i] == 1)
            {
                totalOne++;
            }
        }

        if (totalOne % 3 != 0) {
            return new int[] { -1, 1};
        }

        int averageOne = totalOne/3;
        if ( averageOne == 0) {
            return new int[] {0, binArr.length -1};
        }

        // find the start index for the 3rd part
        int postOnes = 0; int  startThirdPart = binArr.length - 1;
        while (postOnes < averageOne) {
            if (binArr[startThirdPart--] ==1) {
                postOnes++;
            }
        }
        startThirdPart++;

        // end index of first part
        int l = binArr.length - startThirdPart;

        int i = 0;
        while (binArr[i] == 0) {
            i++;
        }

        for (int k = 0; k < l ; k++) {
            if (binArr[i + k] != binArr[startThirdPart + k]) {
                return new int[] {-1,-1};
            }
        }

        int left = i + l - 1;
        // find the end index for the 2nd part
        int j = left + 1;

        while (binArr[j] == 0) {
            j++;
        }
        for (int k = 0; k < l; k++) {

            if (binArr[k + j] != binArr[startThirdPart + k])
            {
                return new int[] {-1,-1};
            }
        }
        int right  = j + l;
        return new int[] {left, right};

    }



    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null)
        {
            int[] input = stringToIntegersArray(line);
            int[] result = findPartitionIndex(input);

            String out = integersToString(result);
            System.out.print(out);
        }

    }

    private static String integersToString(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return "[]";
        }
        String result = "";
        for (int i = 0; i < length ; i++) {
            int number = nums[i];
            result += Integer.toString(number)+", ";
        }
        return "["+ result.substring(0, result.length() - 2) + "]";

    }

    private static int[] stringToIntegersArray(String line) {
        line = line.trim();
        line = line.substring(1, line.length()-1);

        String[] inputString = line.split(",");
        int[] inputNum = new int[inputString.length];

        for (int i = 0; i < inputNum.length ; i++)
        {
            String str = inputString[i].trim();
            inputNum[i] = Integer.parseInt(str);
        }
        return inputNum;
    }

}

