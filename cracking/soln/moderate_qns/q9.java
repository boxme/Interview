import java.util.*;

public class q9
{
    public static void main(String[] args)
    {
    }
}

class WordCount
{
    HashMap<String, Integer> map = new HashMap<>();

    public WordCount(String[] book)
    {
	int len = book.length;

	for (int i = 0; i < len; ++i)
	{
	    String word = book[i];
	    if (word == null || word.isEmpty()) continue;

	    word = word.toLowerCase();

	    if (map.hasKey(word))
	    {
		map.put(word, map.get(word) + 1);
	    }
	    else
	    {
		map.put(word, 1);
	    }
	}
    }

    public int query(String word)
    {
	if (word == null || word.isEmpty()) return 0;
	
	word = word.toLowerCase();

	if (map.hasKey(word))
	{
	    return map.get(word);
	}

	return 0;
    }
}
