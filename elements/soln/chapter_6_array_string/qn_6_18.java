import java.util.*;

// Run-length encoding
// Assume characters are all lower case

public class qn_6_18 {
    
    private int[] count = new int[26];

    public String encode(String original) {
        Arrays.fill(count, 0);
	char[] charArray = original.toCharArray();
	char c = charArray[0];
	count[c - 'a'] = 1;
        StringBuilder strBuilder = new StringBuilder();
	for (int i = 1; i < charArray.length; ++i) {
	    char curr = charArray[i];
	    if (c != curr) {
	        strBuilder.append(count[c - 'a']);
		strBuilder.append(c);
		count[c - 'a'] = 0;
		c = curr;
		count[c - 'a'] = 1;
	    } else {
	        count[c - 'a']++;
	    }
	}

	strBuilder.append(count[c - 'a']);
	strBuilder.append(c);

	return strBuilder.toString();
    }

    public String decode(String encoded) {
        char[] charArray = encoded.toCharArray();
	StringBuilder strBuilder = new StringBuilder();
	for (int i = 0; i < charArray.length; i += 2) {
	    int count = Integer.parseInt(charArray[i]);
	    char c = charArray[i + 1];

	    for (int j = 0; j < count; ++j)
	        strBuilder.append(c);
	}

	return strBuilder.toString();
    }
}
