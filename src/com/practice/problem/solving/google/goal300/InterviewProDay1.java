package com.practice.problem.solving.google.goal300;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/***
 * MICROSOFT :
 *
 * You are given two linked-lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class InterviewProDay1 {

    private static LinkedList<Integer> addTwoLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        for (int i = l1.size()- 1; i >= 0; i--) {
            int firstNode = Integer.parseInt(l1.get(i).toString());
            int secNode = Integer.parseInt(l2.get(i).toString());
            int sum = firstNode + secNode + carry;
            int value = sum%10;
            carry = sum/10;
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> listLeft = new LinkedList<>();
        LinkedList<Integer> listRight = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        listLeft.add(2);
        listLeft.add(4);
        listLeft.add(3);
        listRight.add(5);
        listRight.add(6);
        listRight.add(4);
        resultList = addTwoLinkedList(listLeft, listRight);
        resultList.forEach(a -> System.out.print(" "+a));

    }



}
