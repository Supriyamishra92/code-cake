package com.practice.problem.solving.google.goal300;

/***
 * A building has 100 floors. One of the floors is the highest floor an egg can be dropped from without breaking.
 * If an egg is dropped from above that floor, it will break. If it is dropped from that
 * floor or below, it will be completely undamaged and you can drop the egg again.
 * Given two eggs, find the highest floor an egg can be dropped from without breaking, with as few drops as possible.
 *
 * Brute force approach can be binary Search which will cost us nLogn drops, but here we can do better
 * how  We can make it max 14 drops for even for worst case.
 *
 * Explaination https://www.geeksforgeeks.org/egg-dropping-puzzle-with-2-eggs-and-k-floors/
 * optimal solution is can be formulated as x * (x + 1)/2 >= k, x= drops and K is floors for 2 eggs
 * total sum formula by triangle series : n^2+n/2
 *
 */
public class TwoEgg {

    private static int minDrop(int floors) {
        int eggs = 2;
        // widening the range to drop first egg.
        return (int) Math.ceil((-1.0 + Math.sqrt(1 + 8 * floors))/2.0);
    }

    public static void main(String[] args) {
        int k = 100;
        System.out.println(minDrop(k));
        System.out.println(minDrop(1000));
    }


}
