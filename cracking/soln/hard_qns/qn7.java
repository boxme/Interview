import java.util.*;

public class q7
{
    // If we only need to find the longest word that is made up by 2 words in the list
    // sort the list according to the length of the word, hash each word
    // then for each word in the list, break up the word into 2 parts and find if both are in the list

    public String getLongestWord(String[] list)
    {
	// Sort the array by length in decreasing order
	Arrays.sort(list, new LengthComparator());
	
	Map<String, Boolean> hash = new HashMap<>();
	
	// True == can build the string from smaller string
	for (int i = 0; i < list.length; ++i)
	{
	    hash.put(list[i], true);
	}

	for (String word : list)
	{
	    if (canBuildWords(word, hash, true)) return word;
	}

	return null;
    }

    public boolean canBuildWords(String word, Map<String, Boolean> map, boolean isOriginal)
    {
	if (!isOriginal && map.containsKey(word))
	{
	    return map.get(word);
	}

	int len = word.length();
	for (int i = 0; i < len; ++i)
	{
	    String left = word.subString(0, i);
	    String right = word.subString(i);

	    if (map.containsKey(left) && map.get(left) == true && canBuildWords(right, map, false))
	    {
		return true;
	    }
	}

	map.put(word, false);
	return false;
    }
}

public class LengthComparator extends Comparator<String>
{
    @Override
    public int compare(String o1, String o2)
    {
	return o2.length() - o1.length();
    }
}
