import java.util.*;

public static void main(String[] args)
{
    
}

public static String[] sortStringArray(String[] array)
{
    if (array == null) return null;

    Arrays.sort(array, new AnagramComparator());

    return array;
}

class AnagramComparator implements Comparator<String>
{
    @Override
    public int compare(String s1, String s2)
    {
	if (s1 == null && s2 == null) return 0;

	if (s1 == null && s2 != null) return -1;
	if (s1 != null && s2 == null) return 1;

	int lenDiff = s1.length() - s2.length();	
	if (lenDiff != 0)
	{
	    return lenDiff;
	}
	
	// If anagram will return 0;
	return sort(s1).compareTo(sort(2));
    }

    private String sort(String string)
    {
	char[] array = strig.toCharArray();
	Arrays.sort(array);

	return String.valueOf(array);
    }
}
