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
}
