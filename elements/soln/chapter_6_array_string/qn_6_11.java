import java.util.*;

public class qn_6_11 {
    public static int[] solution(int[] A, int[] perm) {
        Stack<Integer> stack = new Stack<>();
	int len = A.length;

	for (int i = 0; i < len; ++i) {
	    if (perm[i] == -1) continue;

	    stack.push(i);
	    int next = perm[i];
	    perm[i] = -1;
	    while (next != i) {
	        stack.push(next);
		next = perm[next];
		perm[i] = -1;
	    }
	    stack.push(next);

	    int val = A[stack.pop()];
	    while (!stack.isEmpty()) {
	        int index = stack.pop();
		int temp = A[index];
		A[index] = val;
		val = temp;
	    }
	}

	return A;
    }
}
