package com.practice.problem.solving.google.goal300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetPermutation {

    public static String getPermutation(int n, int k) {

    return "";

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
