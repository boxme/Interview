import java.util.*;

public class q3
{
    public int getNextSmallestNumWithSameNumOfBits(int original)
    {
	// Find the LSB
	int lsb = original & (-original);
	
	// Turn off lsb
	original = original & (~lsb);

	// shift lsb to the right by 1
	lsb = lsb >> 1;
	
	// Shifting the lsb of original to the right will give the next smallest
	original = original | lsb;

	return original;
    }

    public int getNextBiggestNumWithSameNumOfBits(int original)
    {
	// Find the LSB
	int lsb = original ^ (-original);

	// Turn off LSB
	original = original ^ (~lsb);


    }
}
