import java.util.*;

public class q3
{
    public int getNextSmallestNumWithSameNumOfBits(int n)
    {
	int c = n;
	int c0 = 0;
	int c1 = 0;

	// Find trailing ones
	while ((c & 1 == 1))
	{
	    c1++;
	    c >>= 1;
	}

	// Find zeros left of the trailing ones block
	while ((c & 1) == 0 && (c != 0)
	{
	    c0++;
	    c >>= 1;
	}


	int p = c1 + c0;

	// Flip rightmost non-trailing 1
	int mask = ~(1 << p);
	n &= mask;

	// Clear all 1s to the right of p
	mask = ~0;
	mask <<= p;
	n &= mask;

	// Insert ones immediately to the right of p
	mask = (1 << (c1 + 1)) - 1;
	mask <<= c0;

	n |= mask;

	return n;
    }

    public int getNextBiggestNumWithSameNumOfBits(int n)
    {
	int c = n;
	int c0 = 0;
	int c1 = 0;
	
	// Find zeros to right of p
	while (((c & 1) == 0) && (c != 0))
	{
	    c0++;
	    c >>= 1; 
	}

	// Find 1s to the right of p
	while ((c & 1) == 1)
	{
	    c1++;
	    c >>= 1;
	}

	// Error if 111111 000000 as there is no bigger number
	if (c0 + c1 == 31 || c0 + c1 == 0)
	{
	    return -1;
	}

	int p = c0 + c1;

	// Flip rightmost non-trailing zero
	int mask = 1 << p;
	n |= mask;

	// Clear all bits to the right of p
	mask = ~0;
	mask <<= p;
	n &= mask;

	// Insert ones to the right
	mask = (1 << c1) - 1;
	n |= mask;

	return n;
    }
}
