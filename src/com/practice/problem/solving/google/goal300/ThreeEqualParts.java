package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.
 *
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
 *
 * Input: [1,0,1,0,1]
 * Output: [0,3]
 *
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

