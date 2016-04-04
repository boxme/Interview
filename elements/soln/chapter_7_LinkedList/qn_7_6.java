import java.util.*;

class qn_7_6 {

    public Node evenListMergeList(Node list) {
        if (list == null) return;

        Node evenListHead, oddListHead;
        Node evenListIter, oddListIter;

        evenListIter = evenListHead = list;
        oddListIter = oddListHead = evenListIter.next;

        while (evenListIter != null && oddListIter != null) {

            if (oddListIter.next != null) {
                evenListIter.next = oddListIter.next;
                evenListIter = evenListIter.next;
            } else {
                break;
            }

            if (evenListIter.next != null) {
                oddListIter.next = evenListIter.next;
                oddListIter = oddListIter.next;
            } else {
                break;
            }
        }

        evenListIter.next = oddListHead;

        return evenListHead;
    }

    class Node {
        int value;
        Node next;
    }
}
