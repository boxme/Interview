import java.util.*;

class qn_11_6 {

    public int binarySearchUnknownLength(int[] A, int k) {
        int p = 0;
        while (true) {
            int idx = (1 << p) - 1;
            try {
                if (A[idx] == k) {
                    return idx;
                } else if (A[idx] > k) {
                    break
                }      
            } catch (Exception) {
                break;
            }
            p++;
        }

        int lo = 1 << (p - 1);
        int hi = (1 << p) - 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            try {
                if (A[mid] == k) {
                    return mid;
                } else if (A[mid] > k){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } catch (Exception) {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
