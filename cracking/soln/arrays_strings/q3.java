import java.util.*;

public void test1()
{
    String string1 = "abcde";
    String string2 = "cdabe";
    
    CheckString check = new CheckString();
    assertTrue(check.isPermutation(string1, string2));
}

public void test2()
{
    String string1 = "abc cde";
    String string2 = "abccd e";
    CheckString check = new CheckString();
    assertTrue(check.isPermutation(string1, string2));
}

public void test3()
{
    String string1 = "";
    String string2 = "acd";
    CheckString check = new CheckString();
    assertFalse(check.isPermutation(string1, string2));
}

public void test4()
{
    String string1 = "abc";
    String string2 = "def";

    CheckString check = new CheckString();
    assertFalse(check.isPermutation(string1, string2));
}

class CheckString
{
    HashMap<Character, Integer> hashMap;

    public boolean isPermutation(String string1, String string2)
    {
	if (string1 == null || string2 == null) return false;
	
	if (string1.isEmpty() || string2.isEmpty()) return false;

	hashMap = new HashMap();
	int len1 = string1.length();
	int len2 = string2.length();
	
	String longerString = len1 >= len2 ? string1 : string2;
	String shorterString = len1 >= len2 ? string2 : string1;

	for (int i = 0; i < longerString.length(); ++i)
	{   
	    char c = longerString.charAt(i);

	    int count = hashMap.containsKey(c) ? hashMap.get(c) : 0;
	    hashMap.put(c, count + 1);
	}

	for (int i = 0; i < shorterString.length(); ++i)
	{
	    char c = shorterString.charAt(i);

	    if (!hashMap.containsKey(c)) 
	    {
		return false;
	    }
	    else 
	    {
		int count = hashMap.get(c);

		if (count == 0) return false;
		
		hashMap.put(c, count - 1);
	    }
	}

	return true;
    }
}

