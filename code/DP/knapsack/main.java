import java.util.*;

public class Main
{
    private int[] weights;
    private int[] values;
    private int[][] memo;

    public void solution(int[] weights, int[] values, int maxSize)
    {
	int numOfItems = weights.length;
	memo = new int[numOfItems][maxSize + 1];
	
	int solution = knapsack(0, maxSize);
    }

    private int knapsack(int itemIdx, int maxSize)
    {
	if (itemIdx == weights.length) return 0;
	if (maxSize == 0) return 0;
	if (memo[itemIdx][maxSize] != 0) return memo[itemIdx][maxSize];
	
	int weight = weights[itemIdx];
	int value = values[itemIdx];
	
	// Cannot choose this item if the weight is more than what you can carry
	if (weight > maxSize) return memo[itemIdx][maxSize] = knapsack(itemIdx + 1, maxSize);

	memo[itemIdx][maxSize] = Math.max(knapsack(itemIdx + 1, maxSize), value + knapsack(itemIdx + 1, maxSize - weight));

	return memo[itemIdx][maxSize];
    }
}
