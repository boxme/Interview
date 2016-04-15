import java.util.*;

public class q8
{
    public static void main(String[] args)
    {
	
    }

    public static int getMaxSum(int[] a)
    {
	int max = Integer.MIN_VALUE;
	int sum = 0;
	for (int i = 0; i < a.length; ++i)
	{
	    sum += a[i];

	    if (sum > max)
	    {
		max = sum;
	    }
	    else if (sum < 0)
	    {
		sum = 0;
	    }
	}

	return max;
    }
}
