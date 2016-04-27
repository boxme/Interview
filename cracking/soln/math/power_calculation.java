import java.util.*;

public class power_calculation
{
    public static int power(int value, int n)
    {
	int sum = power(value, Math.abs(n));

	if (n < 1)
	{
	    return 1 / sum;
	}

	return sum;
    }

    private static int power(int value, int n)
    {
	if (n == 0)
	{
	    return 1;
	}

	if (n == 1)
	{
	    return value;
	}

	// Even number
	if (n % 2 == 0)
	{
	    int sum = power(value, n / 2);
	    return sum * sum;
	}

	return value * power(value, n - 1);
    }
}
