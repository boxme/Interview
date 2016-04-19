import java.util.*;

class qn_14_8 {
    private Node head;

    public Node buildBSTFromSortedDoublyLinkedList(Node L, int n) {
        head = L;
        return buildSortedDoublyLinkedListHelper(0, n);
    }

    public Node buildSortedDoublyLinkedListHelper(int start, int end) {
        if (start >= end) return null;

        int mid = start + ((end - start) / 2);
        Node left = buildSortedDoublyLinkedListHelper(start, mid);

        Node curr = new Node(head.value);

        head = head.next;
        curr.prev = left;
        curr.next = buildSortDoublyLinkedListHelper(mid + 1, end);

        return curr;
    }

    class Node {
        int value;
        Node prev;
	// Only this pointer is used for a singly linkedlist
        Node next;
    }
}
