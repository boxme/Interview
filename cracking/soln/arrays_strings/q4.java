import java.util.*;

public void test1()
{
    String input = "Mr John Smith    ";
    String output = "Mr%20John%20Smith";
    
    StringReplace replace = new StringReplace();

    assertTrue(output.equals(replace.replace(input)));
}

public void test2()
{
    String input = "Mr   ";
    String output = "Mr%20";

    StringReplace replace = new StringReplace();
    assertTrue(output.equals(replace.replace(input)));
}

class StringReplace
{
    public String replace(String input)
    {
	if (input == null) return null;
	
	int spaceCount = 0;
	char[] cArray = input.toCharArray();

	for (int i = 1; i < cArray.size(); ++i)
	{
	    char c = cArray[i];
	    if (Character.isWhitespace(c))
	    {
		continue;
	    }
	    else
	    {
		char prev = cArray[i - 1];
		if (Character.isWhitespace(prev) spaceCount++;
	    }
	}

	if (spaceCount == 0) return String.value(input);

	int endSpaceCount = 0;
	int len = cArray.size();
	for (int i = len - 1; i >= 0; --i)
	{
	    char c = cArray[i];
	    if (Character.isWhitespace(c)) endSpaceCount++;
	    else break;
	}

	final String insert = "%20";
	
	for (int i = len - endSpaceCount - 1, j = len - 1; i >= 0 && j >= 0; i--)
	{
	    char c = cArray[i];
	    if (Character.isWhitespace(c))
	    {
		cArray[j--] = '0';
		cArray[j--] = '2';
		cArray[j--] = '%';
	    }
	    else
	    {
		cArray[j] = c;
		j--;
	    }
	}

	return String.valueOf(cArray);
    }
}
