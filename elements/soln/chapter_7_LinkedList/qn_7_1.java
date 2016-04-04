import java.util.*;

class qn_7_1 {

    public Node mergeTwoLinkedLists(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        Node firstPtr = first, secondPtr = second, newList = new Node;
        while (firstPtr != null && secondPtr != null) {
            if (firstPtr != null && secondPtr != null) {
                if (firstPtr.value > secondPtr.value) {
                    newList.next = secondPtr;
                    secondPtr = secondPtr.next;
                } else {
                    newList.next = firstPtr;
                    firstPtr = firstPtr.next;
                }
            } else {
                if (firstPtr != null) {
                    newList.next = firstPtr;
                } else {
                    newList.next = secondPtr;
                }
                break;
            }
        }

        return newList.next;
    }

    class Node {
        int value;
        Node next;
    }
}
