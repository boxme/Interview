import java.util.*;

public class sum_subarray
{
    public void solution(int[] array)
    {
	int min_sum_subarray = getMinSum(array);
	int max_sum_subarray = getMaxSum(array);
    }

    public int getMinSum(int[] array)
    {
	int min = 0;
	int sum = 0;

	// negate all values in array
	for (int i = 0; i < array.length; ++i)
	{
	    sum += (-array[i]);
	    min = Math.max(min, sum);
	    if (sum < 0) sum = 0;
	}

	return -min;
    }

    public int getMaxSum(int[] array)
    {
	int max = 0;
	int sum = 0;

	for (int i = 0; i < array.length; ++i)
	{
	    sum += array[i];
	    max = Math.max(max, sum);
	    if (sum < 0) sum = 0;
	}

	return max;
    }
}
