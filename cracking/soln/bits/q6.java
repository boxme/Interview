import java.util.*;

public class q6
{
    public static int swapBits(int n)
    {
	int onesInOddPos = 0xAA;
	int onesInEvenPos = 0x55;
	
	n = ((n & onesInOddPos) >> 1) | ((n & onesInEvenPos) << 1);

	return n;
    }
}
