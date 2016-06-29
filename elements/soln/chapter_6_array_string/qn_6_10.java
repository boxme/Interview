import java.util.*;

public class qn_6_10 {
    
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
}
