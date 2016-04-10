import java.util.*;

public static void main(String[] args)
{
}

public static int[] merge(int[] A, int[] B)
{
    if (A == null || B == null) return null;

    int trueALen = trueLength(A);
    int aLen = A.length;
    int bLen = B.length;

    int aPtr = trueALen - 1;
    int bPtr = bLen - 1;
    
    // Pointing to the end
    int ptr = aLen - 1;

    for (aPtr >= 0 && bPtr >= 0)
    {
	int aVal = A[aPtr];
	int bVal = B[bPtr];

	if (aVal < bVal)
	{
	    A[ptr] = bVal;
	    bPtr--;
	}
	else
	{
	    A[ptr] = aVal;
	    aPtr--;
	}

	ptr--;
    }

    while (aPtr >= 0)
    {
	A[ptr--] = A[aPtr--];
    }

    while (bPtr >= 0)
    {
	A[ptr--] = B[bPtr--];
    }

    return A;
}

private static int trueLength(int[] A)
{
    if (A == null) return 0;

    int trueLen = 0;
    for (int i = 0; i < A.length; ++i)
    {
	if (A[i] != Integer.MIN_VALUE;)
	  trueLen++;
    }

    return trueLen;
}
