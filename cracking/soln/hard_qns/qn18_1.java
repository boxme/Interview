import java.util.*;

public class qn18_1 
{
    // Compare the bits
    // if one is 1 & the other is 0, then new bit becomes 1
    // if both are 1s, then new bit becomes 0, and bring the one over
    public int add(int x, int y)
    {
	if (x == 0) return y;
	if (y == 0) return x;
	
	// No bits is turn on
	int result = 0;
	int bringover = 0;
	int index = 0;

	while (x > 0 || y > 0)
	{
	    boolean isXEven = isLastBitTurnedOn(x);
	    boolean isYEven = isLastBitTurnedOn(y);

	    if (isXEven && isYEven)
	    {
		if (bringover > 0)
		{
		    result = increaseBitByOneInIndex(index, result);
		}
		else
		{
		    bringover = 1;
		}
	    }
	    else if (isXEven || isYEven)
	    {
		if (bringover <= 0)
		{
		    result = increaseBitByOneInIndex(index, result);
		}
	    }
	    else
	    {
		if (bringover > 0)
		{
		    result = increaseBitByOneInIndex(index, result);
		    bringover = 0;
		}
	    }
	    
	    x >>= 1;
	    y >>= 1;
	    index++;
	}

	return result;
    }

    private int increaseBitByOneInIndex(int index, int result)
    {
	return result | (1 << index);
    }

    private boolean isLastBitTurnedOn(int x)
    {
	int mask = 1;
	return (x & mask) == 1;
    }
}
