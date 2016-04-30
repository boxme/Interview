import java.util.*;

public class q1
{
    public static int bitInsertion(int m, int n, int i, int j)
    {
	// Shift m so that it lines up with bits j through i
	m = m << i;
	
	// Clear bits j through i in N
	for (int bit = i, bit <= j; ++bit)
	{
	    n ^= ~(1 << bit);
	}
	
	// Merge m and n
	return n | m; 
    }

    // Book solution
    public static int solution(int m, int n, int i, int j)
    {
	// Create a mask to clear bits i through j in n
	// Example: i = 2, j = 4. Results should be 11100011
	
	// Bits all set
	int allOnes = ~0;
	
	// 11100000
	int left = (allOnes << (j+1));
	
	// 00000011
	int right = ((1 << i) - 1);

	// Merge to create mask 11100011
	int mask = left | right;

	// Clear bits j through i in N
	n = n & mask;

	// Shit m so that it lines up with bits j through i
	m = m << i;

	// Merge them
	return n | m;
    }


}
