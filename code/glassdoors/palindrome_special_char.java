import java.util.*;

public class palindrome_special_char
{
    public boolean isPalindrome(String s)
    {
	if (s == null || s.isEmpty()) return true;

	char[] array = s.toCharArray();
	int i = 0;
	int j = array.length - 1;
	
	while (i < j)
	{
	    char a = array[i];
	    char b = array[j];

	    if (Character.isLetter(a) && Character.isLetter(b))
	    {
		if (Character.toLowerCase(a) != Character.toLowerCase(b))
		{
		    return false;
		}

		i++;
		j--;
		continue;
	    }

	    if (!Character.isLetter(a))
	    {
		i++;
	    }

	    if (!Character.isLetter(b))
	    {
		j--;
	    }
	}

	return true;
    }
}
