import java.util.*;

public static void main(String[] args)
{
    
}

class Soln
{
    CheckRotation check;

    public Soln()
    {
      check = new CheckRotation();
    }

    public void solution()
    {
	test("waterbottle", "erbottlewat", true);
	test("a", "a", true);
	test("abcde", "deabc", true);
	test("abcde", "edabc", false);
	test("aabac", "acaab", true);
    }

    private void test(String s1, String s2, boolean expected)
    {
	assertEquals(check.isRotation(s1, s2), expected);
    }
}

class CheckRotation
{
    public boolean isRotation(String s1, String s2)
    {
	if (s1 == null || s2 == null) return false;
	
	HashMap<String, Boolean> hash = new HashMap<>();

	for (int i = 0; i < s1.length(); ++i)
	{
	    String sub = s1.subString(i);
	    hash.put(sub, true);
	}

	return hash.containsKey(s2);
    }

    // Solution from the book
    public boolean isRotation(String s1, String s2)
    {
	if (s1 == null || s2 == null) return false;

	int len1 = s1.length();
	int len2 = s2.length();

	if (len1 == len2 && len1 != 0)
	{
	    String s1s1 = s1 + s1;
	    return isSubstring(s1s1, s2);
	}

	return false;
    }


    // Assume you have a method isSubString(String s1, String s2)
    private boolean isSubstring(String s1, String s2)
    {
	// Implement for us
    }
}
