import java.util.*;

public class repeat_qn_11_6
{
    public static int searchUnknownLenArray(int[] array, int k)
    {
	int p = 0;
	while(true)
	{
	    int index = 1 << p;
	    try
	    {
		if (array[index] == k)
		{
		    return index;
		}

		if (array[index] > k)
		{
		    break;
		}
	    }
	    catch (Exception e)
	    {
		break;
	    }

	    p++;
	}

	int lo = 1 << (p - 1);
	int hi = (1 << p) - 1;

	while (lo < hi)
	{
	    try
	    {
		int mid = hi - lo / 2 + lo;
		int value = array[mid];

		if (value == k)
		{
		    return mid;
		}

		if (value > k)
		{
		    hi = mid - 1;
		}
		else
		{
		    lo = mid + 1;
		}
	    }
	    catch (Exception e)
	    {
		hi = mid - 1;
	    }
	}
    }
}
