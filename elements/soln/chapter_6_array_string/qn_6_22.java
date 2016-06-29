import java.util.*;

public class qn_6_22 {
    
    public static List<String> phoneNumMnemonic(Map<Integer, Set<Character>> M, String number) {
	List<String> result = new ArrayList<>();
	recursion(M, result, 0, number, "");
	return result;
    }

    private static void recursion(Map<Integer, Set<Character>> M, List<String> result, int index, String num, StringBuilder word) {
	if (index == num.length()) {
	    result.add(word.toString());
	    return;
	}

	int digit = Integer.parseInt(num.chatAt(index));
	Set<Character> mapping = M.get(digit);

	for (Character c : mapping) {
	    word.add(c);
	    recursion(M, result, index + 1, num, word);
	    word.remove(word.length() - 1);
	}
    }
}
