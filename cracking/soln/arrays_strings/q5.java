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
	
	// Take note of the edge case where size > single digit
	int newLen = countCompression(input);
	if (newLen >= len) return input;

	// If we aren't allowed to us string buffer, then we need to use char array
	StringBuffer buffer = new StringBuffer();
	int len = input.length();
	char last = input.charAt(0);
	int count = 1;
	for (int i = 0; i < len; ++i)
	{
	    char c = input.charAt(i);

	    if (c == last)
	    {
		count++;
	    }
	    else
	    {
		buffer.append(last);
		buffer.append(count);

		last = c;
		count = 1;
	    }
	}
	
	buffer.append(last);
	buffer.append(count);

	return buffer.toString();
    }

    // Better way to count
    private int countCompression(String input)
    {
	int len = input.length();
	int count = 1;
	char last = input.charAt(0);
	int newLen = 0;
	for (int i = 1; i < len; ++i)
	{
	    char c = input.charAt(i);
	    if (last == c)
	    {
		count++;
	    }
	    else
	    {
		last = c;
		newLen += 1 + String.value(count).length();
		count = 1;
	    }
	}
	
	newLen += 1 + String.value(count).length();
	return newLen;
    }
}
