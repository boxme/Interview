import java.util.*;

public class qn_6_10 {
    
    public static int[] permuteArray(int[] A, int[] perm) {
	int n = A.length;
	int oldPos = 0;

	while (oldPos < n) {
	    
	    int val = A[oldPos];
	    while (perms[oldPos] != -1) {
		int newPos = perm[oldPos];
		perm[oldPos] = -1;
		int temp = A[newPos];
		A[newPos] = val;

		oldPos = newPos;
		val = temp;
	    }

	    oldPos++;
	}

	return A;
    }
}
