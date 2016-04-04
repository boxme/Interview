import java.util.*;

class qn_7_2 {

    Node hare, tortoise;

    public Node returnStartOfCycle(Node head) {
        if (head == null) return;

        hare = tortoise = head;
        while (hare != null && hare.next != null && hare.next.next != null) {
            hare = moveByOne(moveByOne(hare));
            tortoise = moveByOne(tortoise);

            if (hare == tortoise) break;
        }

        if (hare == tortoise) {
            // Cycle detected
            
            // Get the len of the cycle
            int len = 0;
            do {
                len++;
                hare = moveByOne(hare);
            } while (hare != tortoise);
            
            Node advance = head;
            while (len-- > 0) {
                advance = moveByOne(advance);
            }

            Node startOfCycle = head;
            while (startOfCycle != advance) {
                startOfCycle = moveByOne(startOfCycle);
                advance = moveByOne(advance);
            }

            return startOfCycle;
        }
        
        // No cycle detected
        retur null;
    }

    private Node moveByOne(Node node) {
        if (node == null) return null;

        return node = node.next;
    }

    class Node {
        int value;
        Node next;
    }
}
