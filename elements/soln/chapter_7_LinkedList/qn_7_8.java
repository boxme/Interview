import java.util.*;

class qn_7_8 {

    public void deleteKthElementFromLastOfList(Node head, int k) {
        if (head == null) return;

        Node fast = head, slow = head;
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }

        if (fast == null) {
            return;
        }

        Node predecessor;
        while (fast != null) {
            predecessor = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // node slow is the kth element from the back, so delete it
        predecessor.next = slow.next;
        slow.next = null;
    }

    class Node {
        int value;
        Node next;
    }
}
