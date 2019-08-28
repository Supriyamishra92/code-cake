package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SplittableRandom;

public class MinInRotatedArray
{

    public static int findMinByModifiedBS(int[] nums)
    {
        int left = 0;
        int right = nums.length-1;

        if (right+1 == 1)
        {
            return nums[left];
        }
        if (nums[left] < nums[right])
        {
            return nums[left];          // input array is not rotated.
        }

        while (right >= left)
        {   int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid+1])
            {
                return nums[mid+1];
            }
            if (nums[mid -1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return -1;
    }
}

class MainInput {
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

            int ret = new MinInRotatedArray().findMinByModifiedBS(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

