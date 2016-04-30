import java.util.*;

public class q7
{
    // Without using bits
    public static int findMissingInt(int[] array)
    {
	int n = array.length;
	int sum = n * (n - 1) / 2;

	int total = 0;
	for (int i = 0; i < n; ++i)
	{
	    total += array[i];
	}

	// Return missing number
	return sum - total;
    }
    
    // Using bits
    public static int findMissingNumber()
    {
	
    }
}
