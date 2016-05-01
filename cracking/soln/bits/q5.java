import java.util.*;

public class q5
{
    public static int numberOfBitsReq(int a, int b)
    {
	int bitsSetInA = countBitsSet(a);
	int bitsSetInB = countBitsSet(b);

	return Math.abs(bitsSetInA - bitsSetInB);
    }

    public static int countBitsSet(int n)
    {
	int count = 0;

	while (n > 0)
	{
	    count++;
	    n = (n - 1) & n;
	}

	return count;
    }

    // Book solution
    public static int bitSwapRequired(int a, int b)
    {
	// XOR to get all the bits differences
	int diff = a ^ b;

	// Count number of bits in diff
	// i = i &  (i - 1) is to clear the LSB

	int count = 0;
	for (int i = diff; i != 0; i &= (i - 1))
	{
	    count++;
	}

	return count;
    }
}
