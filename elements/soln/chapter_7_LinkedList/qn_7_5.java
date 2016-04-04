import java.util.*;

class qn_7_5 {

    public Node getStartingOfOverlappingListsWithPossibleCycle(Node L, Node R) {
        Node cycleL = findStartOfCycle(L);
        Node cycleR = findStartOfCycle(R);

        if (cycleL == null && cycleR == null) {
            // No cycle, find the overlapping node using qn_7_4
            return findStartOfOverlappingLists(L, R);
        }

        if (cycleL == null || cycleR == null) {
            // Lists are disjointed
            return null;
        }

        // Check that the two lists' cycles are sharing the same cycle
        Node temp = cycleL;
        do {
            temp = temp.next;
        } while (temp != cycleR && temp != cycleL);

        if (temp != cycleR) {
            // Cycles are disjointed
            return null;
        }

        int lenLToStartOfCycle = distance(L, cycleL);
        int lenRToStartOfCycle = distance(R, cycleR);
        if (lenLToStartOfCycle > lenRToStartOfCycle) {
            L = advanceListBy(lenLToStartOfCycle - lenRToStartOfCycle, L);
        } else {
            R = advanceListBy(lenRToStartOfCycle - lenLToStartOfCycle, R);
        }

        while (L != R && L != cycleL && R != cycleR) {
            L = L.next; R = R.next;
        }

        // If L1 == L2 before reaching root1, it means the overlap first occurs
        // before the cycle starts; otherwise, the first overlapping node is not
        // unique, so we can return any node on the cycle.
        return L == R ? L : cycleL;
    }

    public int distance(Node head, Node pointer) {
        int dist = 0;
        Node temp = head;
        while (temp != pointer) {
            temp = temp.next;
            dist++;
        }

        return dist;
    }

    public Node advanceListBy(int k, Node list) {
        while (k-- > 0) {
            list = list.next;
        }

        return list;
    }

    class Node {
        int value;
        Node next;
    }
}
