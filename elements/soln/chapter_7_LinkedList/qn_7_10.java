import java.util.*;

class qn_9_10 {

    public boolean isSinglyLinkedListPalindrome(Node head) {
        if (head == null) return false;
        
        if (L == null) {
            return true;
        }
        
        // Finds the second half of L.
        Node slow = L, fast = L;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Compare the first half and the reversed second half lists.
        Node firstHalfIter = L;
        Node secondHalfIter = reverseLinkedList(slow.next);
        
        while (secondHalfIter != null && firstHalfIter != null) {
            if (secondHalfIter.data != firstHalfIter.data) {
                return false;
            }
            secondHalfIter = secondHalfIter.next;
            firstHalfIter = firstHalfIter.next;
        }
        return true;
    }

    class Node {
        int value;
        Node next;
    }
}
