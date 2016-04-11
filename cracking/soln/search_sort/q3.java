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

// Correct answer
public static int binarySearch(int[] array, int lo, int hi, int num)
{
    if (array == null) -1;

    if (lo > hi) return -1;

    int mid = (hi - lo) / 2 + lo;

    if (array[mid] == num) return mid;
    
    // Left side is properly ordered
    if (array[lo] < array[mid])
    {
	if (array[lo] <= num && num <= array[mid])
	{
	    // Search left
	    return binarySearch(array, lo, mid - 1, num);
	}
	else
	{
	    // Search right
	    return binarySearch(array, mid + 1, hi, num);
	}
    }
    // Right side is properly ordered
    else if (array[mid] < array[right])
    {
	if (array[mid] <= num && num <= array[hi])
	{
	    // Search right
	    return binarySearch(array, mid + 1, hi, num);
	}
	else
	{
	    // Search left
	    return binarySearch(array, lo, mid - 1, num);
	}
    }
    // Left side is all repeat
    else if (array[lo] == array[mid])
    {
	if (array[mid] != array[hi)
	{
	    // Search right
	    return binarySearch(array, mid + 1, hi, num);
	}
	else
	{
	    // Takes care of an array like [7, 7, 7, 4, 5, 6, 7, 7]
	    // Search for both halves
	    int result = binarySearch(array, lo, mid - 1, num);
	    if (result == -1)
	    {
		return binarySearch(array, mid + 1, hi, num);
	    }
	    return result;
	}
    }

    return -1;
}
