package com.practice.problem.solving.google.goal300;

import java.util.Arrays;

/*** Given all three arrays, write a method to check that my service is first-come,
 first-served. All food should come out in the same order customers requested it.
*/
public class OrderProcessing {


    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        //base case
        if (servedOrders.length == 0 ) {
            return true;
        }
        if (takeOutOrders.length >0 && servedOrders[0] == takeOutOrders[0] ){
            return isFirstComeFirstServed(removeFirstServedOrder(takeOutOrders),dineInOrders, removeFirstServedOrder(servedOrders));
        } else if (dineInOrders.length > 0 && servedOrders[0] == dineInOrders[0]) {
            return isFirstComeFirstServed(takeOutOrders, removeFirstServedOrder(dineInOrders), removeFirstServedOrder(servedOrders));
        } else {
            return false;
        }




    }

    private static int[] removeFirstServedOrder(int[] orders) {
        return Arrays.copyOfRange(orders, 1, orders.length);
    }











    public static void main(String[] args) {
        final int[] takeOutOrders = {};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {2, 3, 6};
        boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders,servedOrders);
        System.out.println(result);

    }




    //










}



