import java.util.*;

public static void main(String[] args)
{
}

public static void merge(int[] A, int[] B)
{
    final int lenA = A.length;
    final int lenB = B.length;

    int aPtr = 0;
    int bPriPtr = 0;
    int bSecPtr = 0;

    while (bPriPtr < lenB)
    {
	int bVal = B[bPriPtr];
	
	if (bSecPtr == bPriPtr)
	{
	    int aVal = A[aPtr];
	    if (aVal <= bVal)
	    {
		aPtr++;
	    }
	    else
	    {
		A[aPtr] = bVal;
		A[bPriPtr] = aVal;
		
		bPriPtr++;
		aPtr++;
	    }
	}
	else 
	{
	    int val = B[bSecPtr];
	    if (val <= bVal)
	    {
		B[bSecPtr] = A[aPtr];
		A[aPtr] = val;
		aPtr++;
	    }
	    else 
	    {
		B[bPriPtr] = A[aPtr];
		A[aPtr] = bVal;
		bPrPtr++;
		aPtr++;
	    }
	}

	if (aPtr >= lenA) break;
    }
}
