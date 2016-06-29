import java.util.*;

// Assumption: Must restore perm array back

public class qn_6_10 {
    
    // O(n2) complexity but constant space complexity
    public static int[] permuteArray(int[] A, int[] perm) {
        int len = A.length;

	for (int i = 0; i < len; ++i) {
	    boolean isMin = true;
	    int j = perm[i];

	    while (i != j) {
	        if (j < i) {
		    isMin = false;
		    break;
		}
	        j = perm[j];
	    }

	    if (isMin) {
	        int currPos = i;
	        int curr = A[currPos];
		
		do {
		    int nextPos = perm[currPos];
		    int temp = A[nextPos];
		    A[nextPos] = curr;
		    currPos = nextPos;
		    curr = temp;
		} while (i != currPos);
	    }
	}

	return A;
    }

    // O(n) complexity, but inplicit O(n) space complexity to restore the perm array
    public static int[] permuateArray(int[] A, int[] perm) {
        int len = A.length;
	int[] copyPerm = Arrays.copyOf(perm, len);

	for (int i = 0; i < len; ++i) {
	    int currPos = i;
	    int curr = A[currPos];

	    while (perm[currPos] != -1) {
	        int nextPos = perm[currPos];
		perm[currPos] = -1;
		int temp = A[nextPos];
		A[nextPos] = curr;
		curr = temp;
	        currPos = nextPos;
	    }
	}

	perm = copyPerm;
	return A;
    }
}
