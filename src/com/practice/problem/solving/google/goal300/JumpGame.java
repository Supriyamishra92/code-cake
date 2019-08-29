package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.practice.problem.solving.google.goal300.MainInput.stringToIntegerArray;

/***
 *
 */
enum Index{
    GOOD, BAD, UNKNOWN
}
public class JumpGame {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

            int[] nums = stringToIntegerArray(line);
            boolean retA = new JumpGame().findGoodIndexByBruteForce(nums);
            boolean retB = new JumpGame().findGoodIndexByBackTracking(nums);
            boolean retC = new JumpGame().findGoodIndexByDPBottomUp(nums);
            boolean retD = new JumpGame().findGoodIndexByDPTopDown(nums);
            boolean retE = new JumpGame().findGoodIndexByGreedyApproach(nums);

            String outA = String.valueOf(retA);
            String outB = String.valueOf(retB);
            String outC = String.valueOf(retC);
            String outD = String.valueOf(retD);
            String outE = String.valueOf(retE);


            System.out.println("Brute Force : " +outA);
            System.out.println("BackTracking :" + outB);
            System.out.println("BottomUp : "+outC);
            System.out.println("Top Down : "+outD);
            System.out.println("Greedy : "+outE);

        }
    }

    private boolean findGoodIndexByGreedyApproach(int[] nums) {
        int lastPosition = nums.length-1;
        for (int i = lastPosition; i >= 0 ; i--) {
            if (i+nums[i] >=lastPosition) {
                lastPosition = i;
            }

        }
        return lastPosition == 0;

    }

    private boolean findGoodIndexByDPBottomUp(int[] nums) {
        int len = nums.length;
        Index[] memo = new Index[len];
        for (int i = 0; i < len; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[len -1] = Index.GOOD;

        for (int i = len - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], len - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;

    }

    private boolean findGoodIndexByBackTracking(int[] nums) {
        //We start from the first position and jump to every index that is reachable.
        // We repeat the process until last index is reached. When stuck, backtrack.
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length -1) {
            return true;
        }
        int furthestJump = Math.min( position+nums[position], nums.length -1);
        // for little better performance for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
        for (int nextPosition = position +1; nextPosition <= furthestJump ; nextPosition++) {
            if (canJumpFromPosition(nextPosition,nums)) {
                return true;
            }

        }
        return false;

    }
    Index[] memo;
    private boolean findGoodIndexByDPTopDown(int[] nums) {

        memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[nums.length -1] = Index.GOOD;
        return canJumpFromPositionTopDown(0, nums);
    }

    private boolean canJumpFromPositionTopDown(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return  memo[position] == Index.GOOD ? true : false;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position+1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionTopDown(nextPosition,nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
        
    }

    private boolean findGoodIndexByBruteForce(int[] nums) {
        int len = nums.length -1;
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1 && nums[0] == 1) {
            return true;
        }
        int possibleJump = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == len -i ) {
                return true;
            } possibleJump  += nums[i];
            if (possibleJump == len) {
                return true;
            }
            while (possibleJump < len) {
                possibleJump += nums[i];
                if (possibleJump == len) {
                    return true;

                }
            }
        }
        return false;
    }
    
}
