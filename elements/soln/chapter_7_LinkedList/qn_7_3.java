import java.util.*;

class qn_7_3 {

    public Node findMedianOfCirculerSortedLinkedList(Node randomPointer) {
        if (randomPointer == null) return null;

        Node smallestNodeFound = randomPointer;
        Node iter = randomPointer;
        int n = 0;
        do {
            n++;
            iter = iter.next;
            if (smallestNodeFound.value > iter.value) {
                smallestNodeFound = iter;
            }
        } while (iter != randomPointer);

        int mid = (n - 1) / 2;
        while (mid-- > 0) {
            smallestNodeFound = smallestNodeFound.next;
        }

        return smallestNodeFound;
    }

    class Node {
        int value;
        Node next;
    }
}
