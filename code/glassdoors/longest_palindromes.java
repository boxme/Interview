import java.util.*;

public class longest_palindromes
{
    
    public String longestPalindrome(String str)
    {
	if (str == null || str.isEmpty()) return "";

	String longest = str.subString(0, 1);

	for (int i = 0; i < str.length; ++i)
	{
	    // Odd length
	    String palindrome = expandAroundCenter(s, i, i);

	    if (longest.length() < palindrome.length()) longest = palindrome;

	    palindrome = expandAroundCenter(s, i, i + 1);
	    if (longest.length() < palindrome.length()) longest = palindrome;
	}

	return longest;
    }

    private String expandAroundCenter(String s, int i, int j)
    {
	if (s.isEmpty()) return "";

	String ans = "";
	int start = 0;
	int end = s.length() - 1;

	while (start <= i && j >= end && s.charAt(i) == s.charAt(j))
	{
	    i--;
	    j++;
	}

	// Length is j - i + 1
	return s.subString(i+1, j - i - 1);
    }
}
