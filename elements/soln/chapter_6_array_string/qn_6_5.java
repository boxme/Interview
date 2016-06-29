import java.util.*;

public class qn_6_5 {

    public List<Integer> subsetMod(int[] A) {
	int n = A.length;
	int[] prefixSum = new int[n];

	for (int i = 0; i < n; ++i) {
	    prefixSum[i] = i > 0 ? A[i] + prefixSum[i-1] : A[i];
	    prefixSum[i] %= n;
	}

	int[] table = new table[n]; // table to record the index that o -> i gives prefixSum[i]
	Arrays.fill(table, -1);

	for (int i = 0; i < n; ++i) {
	    if (prefixSum[i] == 0) {
		
		// answer is index 0 -> i;
		
		return generateList(0, i);
	    } else if (table[prefixSum[i]] != -1) {
		
		// answer is index table[prefixSum[i]] + 1 -> i
		// because here prefixSum[i] == prefixSum[j], hence the mod will be 0 if you minus prefixSum[j] - prefixSum[i]

		return generateList(table[prefixSum[i]] + 1, i);
	    } 

	    table[prefixSum[i]] = i;
	}
    }

    private List<Integer> generateList(int start, int end) {
	List<Integer> result = new ArrayList<>();
	for (int i = start; i <= end; ++i) {
	    result.add(i);
	}

	return result;
    }
}
