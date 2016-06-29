import java.util.*;

public class qn_6_6 {
    
    public static Result longestContiguousIncreasingSubarray(int[] A) {
	int lo = 0; int hi = 0;
	int val = A[hi++];
	int maxLen = 1;
	Result result = new Result(0, 0);

	for (int i = hi, i < A.length; ++i) {
	    if (A[hi] > A[hi - 1]) {
		int len = i - lo + 1;
		
		if (len > maxLen) {
		    maxLen = len;
		    result.i = lo;
		    result.j = j;
		}
	    } else {
		lo = j;
	    }
	}

	return result;
    }

    private static class Result {
	int i;
	int j;

	public Result(int x, int y) {
	    i = x;
	    j = y;
	}
    }
}
