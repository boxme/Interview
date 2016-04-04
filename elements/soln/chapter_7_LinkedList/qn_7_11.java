import java.util.*;

class qn_7_11 {

    public Node zipList(Node list) {
        if (list == null || list.next == null) return list;

        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Slow is on the mid point of the list
        Node firstHalfList = list;
        Node secondHalfList = slow.next;

        // Seperate the two list
        slow.next = null;

        // Reverse the second half list
        secondHalfList = reverseList(secondHalfList);

        // Interleave the first half and the reversed of the second half
        Node firstHalfIter = firstHalfList;
        Node secondHalfIter = secondHalfList;
        while (secondHalfIter != null) {
            Node temp = secondHalfIter.next;
            secondHalfIter.next = firstHalfIter.next;
            firstHalfIter.next = secondHalfIter;
            firstHalfIter = firstHalfIter.next.next;
            secondHalfIter = temp;
        }

        return list;
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        Node prev;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return temp;
    }

    class Node {
        int value;
        Node next;
    }
}
