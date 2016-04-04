import java.util.*;

class qn_7_12 {

    public Node copyOfSkipList(Node head) {
        if (head == null) return null;

        // Stage 1: Makes a copy of the original list without assigning the jump
        //          field, and creates the mapping for each node in the original
        //          list to the copied list.
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.value);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Stage 2: Assigns the jump field in the copied list.
        curr = head;
        while (curr != null) {
            if (curr.jump != null) {
                curr.next.jump = curr.jump.next;
            }
            curr = curr.next.next;
        }

        // Stage 3: Reverts the original list, and assigns the next field of
        //          the copied list.
        curr = head;
        Node copiedListHead = curr.next;
        while (curr.next != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            curr = temp;
        }

        return copiedListHead;
    }

    class Node {
        int value;
        Node next;
        Node jump;

        public Node(int value) {
            this.value;
        }
    }
}
