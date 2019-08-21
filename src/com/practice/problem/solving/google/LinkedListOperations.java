package com.practice.problem.solving.google;

/***
 * Delete a node from a singly-linked list, given only a variable pointing to that node.
 * required time and space complexity : O(1) time and O(1) space
 * There are two potential side-effects:
 *
 * Any references to the input node have now effectively been reassigned to its next node.
 * In our example, we "deleted" the node assigned to the variable b, but in actuality we just gave it a new
 * value (2) and a new next! If we had another pointer to b somewhere else in our code and we were assuming it still
 * had its old value (8), that could cause bugs.
 * If there are pointers to the input node's original next node, those pointers now point to a "dangling"
 * node (a node that's no longer reachable by walking down our list). In our example above, c is now dangling. If we changed c,
 * we'd never encounter that new value by walking down our list from the head to the tail.
 * Complexity
 * O(1)time and O(1)space.
 *
 * In-place operations like this can save time and/or space, but they're risky.
 * If you ever make in-place modifications in an interview,
 * make sure you tell your interviewer that in a real system you'd carefully
 * check for side effects in the rest of the code base.
 *
 */
public class LinkedListOperations<T> {



    public static void deleteNode(Node nodeToDelete) {

        if (nodeToDelete != null) {
            Node nextNode = nodeToDelete.next();
            nodeToDelete.value = nextNode.value;
            nodeToDelete.next = nextNode.next;

        } else {
            throw new IllegalArgumentException("Can't delete a null node :P");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        final Node first = new Node(1);
        final Node second = new Node(2);
        final Node third = new Node(3);

        final Node list = first;
        first.add(second);
        second.add(third);
        display(list);
        deleteNode(second);
        System.out.println("After Deletion");
        display(list);
    }

    public static void display(final Node aNode) {
        System.out.println("List is : ");
        Node tmp = aNode;
        while (tmp != null) {
            System.out.print(tmp.value()+" ");
            tmp = tmp.next();
        }
    }

}

class Node {

    public int value;

    public Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this(value, null);
    }

    public void add(final Node node) {
        this.next = node;
    }

    public int value() {
        return value;
    }

    public Node next() {
        return next;
    }
}
