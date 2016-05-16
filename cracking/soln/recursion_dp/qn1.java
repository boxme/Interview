import java.util.*;

public class qn1 {
    private int[] memo;

    // The answer will overflow the bounds of an integer (N = 27)
    public int solution(int N) {
	memo = new int[N+1];
	Arrays.fill(memo, -1);

	return recursive(N);
    }

    private int recursive(int n) {
	if (n == 0) return 0;
	if (n < 0) return -1;

	if (memo[n] != -1) return memo[n];

	return memo[n] = 3 + recursive(n-1) + recursive(n-2) + recursive(n-3);
    }
}
