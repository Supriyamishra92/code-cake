package com.practice.problem.solving.google.goal300;

import java.util.LinkedList;

/**
 * Google:
 *
 * Given a singly-linked list, reverse the list. This can be done iteratively or recursively. Can you get both solutions?
 *
 * Example:
 * Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL
 * Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL
 */
public class InterviewProDay6 {
    private  Node head;

    //Iterative Approach
    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

    }

    public void addToLastNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    // reverse function
    public static Node reverseLinkedList(Node currentNode) {
        Node prevNode = null;
        Node nextNode;

        while (currentNode != null) {

            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }

    private static Node recursiveReverseLL(Node currentNode) {
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }
        Node remaining = recursiveReverseLL(currentNode.next);

        currentNode.next.next = currentNode;
        currentNode.next = null;
        return remaining;
    }

    public static void main(String[] args) {
        InterviewProDay6 list = new InterviewProDay6();
        // Creating a linked list
        Node head = new Node(5);
        list.addToLastNode(head);
        list.addToLastNode(new Node(6));
        list.addToLastNode(new Node(7));
        list.addToLastNode(new Node(1));
        list.addToLastNode(new Node(2));

        list.printList(head);
        //Reversing LinkedList
        Node reverseHead = reverseLinkedList(head);
        System.out.println("After reversing");
        list.printList(reverseHead);
        //recursive
        InterviewProDay6 list2 = new InterviewProDay6();
        // Creating a linked list
        Node head1 = new Node(1);
        list.addToLastNode(head1);
        list.addToLastNode(new Node(2));
        list.addToLastNode(new Node(3));
        list.addToLastNode(new Node(4));
        list.addToLastNode(new Node(5));
        System.out.println("recursive reverse list ");
        list.printList(head1);
        Node revHead = recursiveReverseLL(head1);
        System.out.println(" after recursive reverse ");
        list.printList(revHead);
    }
}

