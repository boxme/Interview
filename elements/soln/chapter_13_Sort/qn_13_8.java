import java.util*;

class qn_13_8 {

    public int[] removeDuplicatesFromArray(int[] A) {
        
        int index = 0
        for (int i = 1; i < A.length; ++i) {
            if (A[index] != A[i]) {
                A[++index] = A[i];
            }
        }

        // final index value is the length of the duplicate free array;

        return index + 1;
    }

    public static ListNode<Integer> removeDuplicatesFromList(ListNode<Integer> L) {
        ListNode<Integer> iter = L;
        while (iter != null) {
            // Uses next_distinct to find the next distinct value.
            ListNode<Integer> nextDistinct = iter.next;
            while (nextDistinct != null && nextDistinct.data == iter.data) {
                nextDistinct = nextDistinct.next;
            }
            iter.next = nextDistinct;
            iter = nextDistinct;
        }
        return L;
    }
}
