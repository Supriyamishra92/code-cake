package com.practice.problem.solving.google;

import java.util.LinkedList;

/***
 * Delete a node from a singly-linked list, given only a variable pointing to that node.
 * required time and space complexity : O(1) time and O(1) space
 * but just to practice writing all operation in LinkedList
 */
public class LinkedListOperations {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void deleteNode(LinkedListNode nodeToDelete) {

        LinkedListNode nextNode = nodeToDelete.next;

        if (nodeToDelete != null) {

            nodeToDelete.value = nextNode.value;
            nodeToDelete.next = nextNode.next;
        } else {
            throw new IllegalArgumentException("Can't delete the last node with this technique!");
        }

    }

}
