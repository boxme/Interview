import java.util.*;

public class q2
{
    public static String printBinaryFromDouble(double num)
    {
	if (num >= 1 || num <= 0) return "ERROR";

	StringBuilder binary = new StringBuilder();
	binary.append(".");

	while (num > 0)
	{
	    // Set a limit on length: cannot be more than 32 bits
	    if (binary.length() >= 32)
	    {
		return "ERROR";
	    }

	    num = 2 * num;
	    if (num >= 1)
	    {
		binary.append(1);;
		num -= 1;
	    }
	    else
	    {
		binary.append(0);
	    }
	}

	return binary.toString();
    }
}
