import java.util.*;

public class palindromes_in_string
{
    HashSet<String> answers;

    public void getAllPalindrome(String s)
    {
	answers = new HashSet<>();
	getAllPalindrome(s, 0, s.length() - 1);
    }

    // Own solution
    private void getAllPalindrome(String s, int start, int end)
    {
	if (start < 0 || end >= s.length()) return;

	if (start == end)
	{
	    addToSet(s, start, end);
	    return;
	}

	int mid = (end - start) / 2 + start;

	getAllPalindrome(s, mid, end);
	getAllPalindrome(s, start, mid);

	int len = end - start + 1;

	if (len % 2 == 1)
	{
	    // Odd
	    getPalindromeInOddLen(s, mid, start, end);
	    getPalindromeInEvenLen(s, mid, start, end);
	    getPalindromeInEvenLen(s, mid - 1, start, end);
	}
	else
	{
	    //Even
	    getPalindromeInEvenLen(s, mid, start, end);
	    getPalindromeInOddLen(s, mid, start, end);
	    getPalindromeInOddLen(s, mid + 1, start, end);
	}
    }

    private void addToSet(String s, int start, int end)
    {
	String substring = s.subString(start, end - start + 1);

	if (!answers.contains(subString))
	{
	    answers.add(subString);
	}
    }

    private void getPalindromeInEvenLen(String s, int mid, int start, int end)
    {
	int i = mid;
	int j = i + 1;

	char[] array = s.toCharArray();
	while (i >= start && j <= end)
	{
	    if (array[i] == array[j])
	    {
		addToSets(s, i, j);
		i--;
		j++;
	    }
	    else
	    {
		return;
	    }
	}
    }

    private void getPalindromeInOddLen(String s, int pos, int start, int end)
    {
	int i = pos - 1;
	int j = pos + 1;
	
	char[] array = s.toCharArray();
	while (i >= start && j <= end)
	{
	    if (array[i] == array[j])
	    {
		addToSet(s, i, j);
		i--;
		j++;
	    }
	    else
	    {
		return;
	    }
	}
    }
}
