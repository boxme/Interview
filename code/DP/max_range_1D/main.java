import java.util.*;

public class Main
{
    public int solution(int[] array)
    {
	int max = Integer.MIN_VALUE;
	int sum = 0;
	for (int i = 0; i < array.length; ++i)
	{
	    sum += array[i];
	    max = Math.max(max, sum);
	    if (sum < 0)
	    {
		sum = 0;
	    }
	}

	return max;
    }
}
