import java.util.*;

public class q1
{
    public static int bitInsertion(int m, int n, int i, int j)
    {
	m = m << i;
	
	for (int bit = i, bit <= j; ++bit)
	{
	    n ^= ~(1 << bit);
	}

	return n ^ m; 
    }
}
