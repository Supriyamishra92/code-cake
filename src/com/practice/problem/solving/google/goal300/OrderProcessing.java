package com.practice.problem.solving.google.goal300;

import java.util.Arrays;

/*** Given all three arrays, write a method to check that my service is first-come,
 first-served. All food should come out in the same order customers requested it.
*/
public class OrderProcessing {


    public static boolean isFirstComeFirstServedNaive(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        //base case
        if (servedOrders.length == 0 ) {
            return true;
        }
        if (takeOutOrders.length >0 && servedOrders[0] == takeOutOrders[0] ){
            return isFirstComeFirstServedNaive(removeFirstServedOrder(takeOutOrders),dineInOrders, removeFirstServedOrder(servedOrders));
        } else if (dineInOrders.length > 0 && servedOrders[0] == dineInOrders[0]) {
            return isFirstComeFirstServedNaive(takeOutOrders, removeFirstServedOrder(dineInOrders), removeFirstServedOrder(servedOrders));
        } else {
            return false;
        }

    }
    private static int[] removeFirstServedOrder(int[] orders) {
        return Arrays.copyOfRange(orders, 1, orders.length);

        //BigO(N^2) time and space
    }
// O(N) solution

    public static boolean isFirstComeFirstServedBetter(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        return isFirstComeFirstServedBetter( takeOutOrders, dineInOrders, servedOrders, 0,0 ,0);
    }
    private static boolean isFirstComeFirstServedBetter(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders, int servedOrderIndex,
                                                        int takeOutOrderIndex, int dineInOrderIndex) {
      if (servedOrderIndex == servedOrders.length) {
          return true;
      }
      if ((takeOutOrderIndex < takeOutOrders.length) && (takeOutOrders[takeOutOrderIndex] == servedOrders[servedOrderIndex])) {
          takeOutOrderIndex++;
      } else if ((dineInOrderIndex <dineInOrders.length) && (dineInOrders[dineInOrderIndex] == servedOrders[servedOrderIndex])){
        dineInOrderIndex++;
      } else {
          return false;
      }
      servedOrderIndex++;
      return isFirstComeFirstServedBetter(takeOutOrders, dineInOrders,servedOrders,servedOrderIndex, takeOutOrderIndex,dineInOrderIndex);
    }




    public static void main(String[] args) {
        final int[] takeOutOrders = {};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {2, 3, 6};
        boolean result = isFirstComeFirstServedNaive(takeOutOrders, dineInOrders,servedOrders);
        boolean betterResult = isFirstComeFirstServedBetter(takeOutOrders, dineInOrders,servedOrders);
        System.out.println(result);
        System.out.println(betterResult);

    }




    //










}



