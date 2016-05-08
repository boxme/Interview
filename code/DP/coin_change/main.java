import java.util.*;

public class Main
{
    private int[] memo;
    private int[] coinValues;
    private int[][] d2Memo;

    // Variant: Find number of ways change to the value
    public void solution(int[] values, int value)
    {
	this.coinValues = values;
	memo = new int[values.length][value + 1];
	
	for (int i = 0; i < value.length; ++i)
	{
	    Arrays.fill(memo[i], -1);
	}

	int ans = ways(value, 0);
    }

    private int ways(int value, int indx)
    {
	if (indx >= coinValues.length || value < 0) return 0;
	if (value == 0) return 1;

	if (2dMemo[idx][value] != -1) return 2dMemo[indx][value];

	int coinVal = coinValues[indx];
	
	2dMemo[indx][value] = ways(value, indx+1) + ways(value - coinVal, indx);

	return 2dMemo[idx][value];
    }

    // Variant: Find min number of coins to change to the value
    public void solution(int[] values, int value)
    {
	this.coinValues = values;
	memo = new int[value + 1];
	Arrays.fill(memo, -1);
	int ans = cc(value, 0);
    }

    private int cc(int value, int indx)
    {
	if (indx >= coinValues.length) return 0;
	if (value == 0) return 0;
	if (value < 0) return Integer.MAX_VALUE;
	if (memo[value] != -1) return memo[value];

	int coinVal = coinValues[indx];
	memo[value] = Math.min(cc(value - coinVal, indx) + 1, cc(value, indx + 1));

	return memo[value];
    }
}
