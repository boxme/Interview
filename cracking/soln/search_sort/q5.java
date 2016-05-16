import java.util.*;

public static void main(String[] args)
{
}

public static int binarySearchString(String[] array, int lo, int hi, String text)
{
    if (array == null) return -1;
    if (text == null) return -1;
    if (lo > hi) return -1;

    int mid = hi - lo / 2 + lo;
    if (text.equals(array[mid]))
    {
	return mid;
    }

    if (array[mid].isEmpty())
    {
	// Search both direction

	// Search right first
	int result = binarySearchString(array, mid + 1, hi, text);
	if (result == -1)
	{
	    // Search left
	    return binarySearchString(array, lo, mid - 1, text);
	}

	return result;
    }
    else if (text.compareTo(array[mid] == -1)
    {
	// Search left because mid is bigger than text
	return binarySearchString(array, lo, mid - 1, text);
    }
    else
    {
	// Search right
	return binarySearchString(array, mid + 1, hi, text);
    }
}

// Book solution
public static int searchR(String[] strings, int lo, int hi, String str)
{
    if (lo > hi) return -1;

    int mid = (hi - lo) / 2 + lo;

    if (strings[mid].isEmpty())
    {
	// Search for the nearest non-empty string
	int left = mid - 1;
	int right = mid + 1;
	while (true)
	{
	    if (lo > left || hi < right) return -1;

	    if (!string[left].isEmpty())
	    {
		mid = left;
		break;
	    }

	    if (!string[right].isEmpty())
	    {
		mid = right;
		break;
	    }

	    left--;
	    right++;
	}
    }
    
    // String found
    if (strings[mid].equals(str)) return mid;

    if (strings[mid].compareTo(str) > 0)
    {
	// Search left
	return searchR(strings, lo, mid - 1, str);
    }

    return searchR(strings, mid + 1, hi, str);
}
