import java.util.*;

public class sieve_of_eratos
{
    public static boolean[] ListOfPrimes(int max)
    {
	boolean[] flags = new boolean[max+1];
	Arrays.fill(flags, false);
	flags[0] = false;
	flags[1] = false;

	int prime = 2;
	
	while (prime <= Math.sqrt(max)) 
	{
	    crossOff(flags, prime);
	    prime = findNextPrime(flags, prime);

	    if (prime >= flags.length)
	    {
		break;
	    }
	}

	return flags;
    }

    private static void crossOff(boolean[] flags, int prime)
    {
	for (int i = prime * prime; i < flags.length; i += prime)
	{
	    flags[i] = false;
	}
    }

    private static int findNextPrime(boolean[] flags, int currentPrime)
    {
	for (int i = currentPrime + 1; i < flags.length; ++i)
	{
	    if (flags[i])
	    {
		return i;
	    }
	}
    }
}
