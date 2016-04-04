import java.util.*;

class qn_7_4 {
    public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> L1,
                                                            ListNode<Integer> L2) {
        int L1Length = Length(L1), L2Length = Length(L2);
        
        // Advances the longer list to get equal length lists.
        if (L1Length > L2Length) {
            L1 = advanceListByK(L1Length - L2Length, L1);
        } else {
            L2 = advanceListByK(L2Length - L1Length, L2);
        }
        
        while (L1 != null && L2 != null && L1 != L2) {
            L1 = L1.next;
            L2 = L2.next;
        }
        return L1; // nullptr implies there is no overlap between L1 and L2.
    }
    
    public static ListNode<Integer> advanceListByK(int k, ListNode<Integer> L) {
        while (k-- > 0) {
            L = L.next;
        }
        return L;
    }
    
    private static int Length(ListNode<Integer> L) {
        int len = 0;
        while (L != null) {
            ++len;
            L = L.next;
        }
        return len;
    }
}
