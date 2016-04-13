import java.util.*;

public class q1
{
    
    public static void main(String[] args)
    {
	// Swap a number in place
	swap(5, 10);
	swap(3, 100);
	swap(502, 103);
    }

    public static void swap(int a, int b)
    {
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;

	System.out.println("a: " + a + " b: " + b);
    }
}
