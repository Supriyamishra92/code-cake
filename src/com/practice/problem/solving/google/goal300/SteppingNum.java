package com.practice.problem.solving.google.goal300;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

// SDE 2 Amazon
public class SteppingNum {

        // Method display's all the stepping numbers
        // in range [n, m]
        public static void dfs(int n,int m,int stepNum)
        {
            // If Stepping Number is in the
            // range [n,m] then display
            if (stepNum <= m && stepNum >= n)
                System.out.print(stepNum + " ");

            // If Stepping Number is 0 or greater
            // than m then return
            if (stepNum == 0 || stepNum > m)
                return ;

            // Get the last digit of the currently
            // visited Stepping Number
            int lastDigit = stepNum % 10;
            //System.out.println("ld"+ lastDigit);

            // There can be 2 cases either digit
            // to be appended is lastDigit + 1 or
            // lastDigit - 1
            int stepNumA = stepNum*10 + (lastDigit-1);
            int stepNumB = stepNum*10 + (lastDigit+1);

            // If lastDigit is 0 then only possible
            // digit after 0 can be 1 for a Stepping
            // Number
            if (lastDigit == 0)
                dfs(n, m, stepNumB);

                // If lastDigit is 9 then only possible
                // digit after 9 can be 8 for a Stepping
                // Number
            else if(lastDigit == 9)
                dfs(n, m, stepNumA);
            else
            {
                dfs(n, m, stepNumA);
                dfs(n, m, stepNumB);
            }
        }

        // Prints all stepping numbers in range [n, m]
        // using DFS.
        public static void displaySteppingNumbers(int n, int m)
        {
            // For every single digit Number 'i'
            // find all the Stepping Numbers
            // starting with i
            for (int i = 0 ; i <= 9 ; i++)
                dfs(n, m, i);
        }

        // Driver code
        public static void main(String args[])
        {
            int n = 0, m = 100;

            // Display Stepping Numbers in
            // the range [n,m]
            displaySteppingNumbers(n,m);
        }
    }