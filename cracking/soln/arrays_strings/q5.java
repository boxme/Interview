import java.util.*;

public void test1()
{
    String input = "aabcccccaaa";
    String expected = "a2b1c5a3";
    
    Compress compress = new Compress();
    assertTrue(expected.equals(compress.compress(input)));
}

public void test2()
{
    String input = "a";
    String expected = "a";
    
    Compress compress = new Compress();
    assertTrue(expected.equals(compress.compress(input)));
}

public void test3()
{
    String input = "aa";
    String output = "aa";
    
    Compress compress = new Compress();
    assertTrue(expected.equals(compress.compress(input)));
}

class Compress
{
    public String compress(String input)
    {
	if (input == null) return null;

	HashMap<Character, Integer> hash = new HashMap<>();
	
	int len = input.length();
	int newLen = 0;
	for (int i = 0; i < len; ++i)
	{
	    char c = input.charAt(i);
	    if (hash.containsKey(c))
	    {
		hash.put(c, hash.get(c) + 1);
	    }
	    else
	    {
		newLen += 2;
		hash.put(c, 1);
	    }
	} 

	if (newLen >= len) return input;

	StringBuffer buffer = new StringBuffer();
	for (int i = 0; i < len;)
	{
	    char c = input.charAt(i);
	    int count = hash.get(c);

	    buffer.append(c);
	    buffer.append(count);

	    i += count;
	}

	return buffer.toString();
    }
}
