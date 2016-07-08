import java.util.*;

// Replace 'a' with 'dd' & delete 'b', assume array has enough space for final result
public class qn_6_21 {
    
    public char[] solution(char[] original) {
        int lastIndex = 0;
	int len = original.length;

	for (int i = len - 1; i >= 0; --i) {
	    if (!Character.isWhitespace(original[i])) {
	        lastIndex = i;
		break;
	    }
	}

        int end = len - 1;
	while (lastIndex >= 0) {
	    char c = original[lastIndex];
	    if (c == 'a') {
	        original[end--] = 'd';
		original[end--] = 'd';
	    } else if (c != 'b') {
	        original[end--] = c;
	    }
	    lastIndex--;
	}

	return original;
    }
}
