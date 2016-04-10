import java.util.*;

public static void main(String[] args)
{
    // num == mid, then return mid
    // num > mid && num < hi search right
    // num < mid && num > lo search left
    // num > mid && num > hi search left
    // num < mid && num < lo search right
}

// Wrong answer
public static int binarySearchCircularArray(int[] array, int lo, int hi, int num)
{
    if (array == null) throw new Exception("Empty array");

    if (lo > hi) throw new Exception("Number is not found");

    int mid = (hi - lo) / 2 + lo;

    int midVal = array[mid];
    int hiVal = array[hi];
    int loVal = array[lo];

    // Normal case
    if (midVal == num) 
    {
	return mid;
    }

    if (num > mid && num <= hi)
    {
	return binarySearchCircularArray(array, mid + 1, hi, num);
    }
    
    // Normal case
    if (num < mid && num >= lo)
    {
	return binarySearchCircularArray(array, lo, mid - 1, num);
    }

    // Circular, there might be bigger values on the left
    if (num > mid && num > hi)
    {
	return binarySearchCircularArray(array, lo, mid - 1, num); 
    }

    // Circular, there might be smaller values on the right 
    if (num < mid && num < lo)
    {
	return binarySearchCircularArray(array, mid + 1, hi, num);
    }
}
