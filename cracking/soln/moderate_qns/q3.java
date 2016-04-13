import java.util.*;

public class q3
{
    public static void main(String[] args)
    {
	int num = 101;
	int count = 0;
	int division = 5;

	while (division <= num)
	{ 
	    count += num / division;
	    division *= division;
	}
	

	System.out.println(count);
    }
}
