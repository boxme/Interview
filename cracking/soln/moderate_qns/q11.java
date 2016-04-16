import java.util.*;

public class q11
{
    public static void main(String[] args)
    {
	
    }

    // Wrong answer as this will not generate a number between 0 & 6 in 1/7 probability
    public static int rand7()
    {
	return rand5() + rand5() % 3;
    }

    public static int rand5()
    {
	// Generate a random number between 0 & 4
	return -1;
    }
}
