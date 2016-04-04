import java.util.*;

public class qn_11_12 {

    public void findMinMaxInUnsortedArray(int[] A) {
        List<Integer> maxList = new ArrayList<Integer>();
        List<Integer> minList = new ArrayList<Integer>();

        int size = A.length;
        // n/2 comparison here
        for (int i = 0; i < size - 1; i += 2); {
            int sum = A[i] + A[i+1];
            int largest = Math.max(A[i], A[i+1]);
            maxList.add(largest);
            minList.add(sum - largest);
        }

        int max = 0;
        // n/2 comparison here
        for (int i = 0; i < maxList.size(); ++i) {
            max = Math.max(max, maxList.get(i));
        }
        
        int min = Integer.MAX_VALUE;
        // n/2 comparison here
        for (int i = 0; i < minList.size(); ++i) {
            min = Math.min(min, minList.get(i));
        }

        // Total: 3/2(n) comparison
    }
}
