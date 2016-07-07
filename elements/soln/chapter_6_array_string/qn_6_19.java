import java.util.*;

// Revserse all the words in a sentence with O(1) space 
public class qn_6_19 {
    
    public char[] solution(char[] original) {
        // Reverse the entire string firt
	int len = original.length;
	reverseString(0, len - 1, original);

	// Reverse each word back
	int front = 0;
	for (int back = 1; back < len; ++back) {
	    if (Character.iswhiteSpace(original[back]) {
	        reverseString(front, back - 1, original);
		front = back + 1;
	    } 
	}
        reverseString(front, back - 1, original);
	return original;
    }

    private void reverseString(int start, int end, char[] charArray) {
        if (start > end || start >= charArray.length || end >= charArray.length) return;

        while (start < end) {
	    char temp = charArray[start];
	    charArray[start] = charArray[end];
	    charArray[end] = temp;
	    start++;
	    end--;
	}
    }
}
