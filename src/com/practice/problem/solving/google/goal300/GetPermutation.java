package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/***
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * The basic idea is to decide which is the correct number starting from the highest digit.
 * Use k divide the factorial of (n-1), the result represents the ith not used number.
 * Then update k and the factorial to decide next digit.
 */
public class GetPermutation {

    public static String getPermutation(int n, int k) {
        LinkedList<Integer> notUsed = new LinkedList<Integer>();

        int weight = 1;

        for (int i = 1; i <= n; i++) {
            notUsed.add(i);
            if (i == n)
                break;
            weight = weight * i;
        }

        String res = "";
        k = k - 1;
        while (true) {
            res = res + notUsed.remove(k / weight);
            k = k % weight;
            if (notUsed.isEmpty())
                break;
            weight = weight / notUsed.size();
        }

        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while  ((line = input.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = input.readLine();
            int k = Integer.parseInt(line);
            String result = getPermutation(n,k);
            String out = (result);
            System.out.println(out);
        }
    }
}
