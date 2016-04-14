import java.util.*;

public class q4
{
    public static void main(String[] args)
    {
	findMax(10, 20); 
	findMax(100, 99);
    }

    public static int findMax(int a, int b)
    {
	int c = a - b;
	c = (c >> 31) & 1;
	int max =  a - c * (a-b);
	System.out.println(max);

	return max;
    }
}
