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
    public static int findMissingNumber(ArrayList<BitInteger> array) 
    {
	// Start from the least siginificant bit, and work our way up
	return findMissing(array, 0);
    }

    public static int findMissing(ArrayList<BitInteger> array, int col)
    {
	if (col >= BitInteger.INTEGER_SIZE) return 0;

	ArrayList<BitInteger> oneBits = new ArrayList<>(array.size() / 2);
	ArrayList<BitInteger> zeroBits = new ArrayList<>(array.size() / 2);
	
	for (BitInteger t: : array)
	{
	    if (t.fetch(column) == 0)
	    {
		zeroBits.add(t);
	    }
	    else
	    {
		oneBits.add(t);
	    }
	}

	if (zeroBits.size() <= oneBits.size())
	{
	    int v = findMissing(zeroBits, col + 1);
	    
	    return (v << 1) | 0;
	}
	else
	{
	    int v = findMissing(oneBits, col + 1);

	    return (v << 1) | 1;
	}
    }
}
