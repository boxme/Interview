import java.util.*;

public class count_2
{
    public static void main(String[] args)
    {
	
    }
    
    // Brute force
    private static int count(int n)
    {
	int count = 0;
	for (int i = 0; i <= n; ++i)
	{
	    int number = i;

	    while (number != 0)
	    {
		int remainder = number % 10;
		if (remainder == 2) count++;
		number /= 10;
	    }
	}

	return count;
    }
}
