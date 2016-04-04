import java.util.*;

class qn_7_9 {

    public void reverseSinglyLinkedList(Node head) {
        if (head == null || head.next == null) return head;

        Node front = head;
        Node prev = null;

        while (front != null) {
            Node temp = front.next;
            front.next = prev;
            prev = front;
            front = temp;
        }

        return prev;
    }

    class Node {
        int val;
        Node next;
    }
}
