import java.util.*;

public class qn_6_20 {
    public int solution(String s, String t) {
        RabinKarp rb = new RabinKarp(t);
	return rb.findFirstOccurence(s);
    }
}

public class RabinKarp {
    String pattern;
    final int SIZE = 997;
    final int BASE = 31;
    
    long rm;
    long hashCode;

    public RabinKarp(String pattern) {
        this.pattern = pattern;
        int len = pattern.length();
	rm = 1;
	for (int i = 1; i < len; ++i) {
	    rm = (rm * BASE) % SIZE;
	}

	this.hashCode = hashCode(pattern);
    }

    private int hashCode(String string) {
        int len = string.length();
	int code = 1;
	for (int i = 0; i < len; ++i) {
	    code = (((code * BASE) % SIZE) + string.charAt(i)) % SIZE;
	}

	return code;
    }

    public int findFirstOccurrence(String text) {
        if (text.length() < pattern.length()) return -1;

	final int M = pattern.length();
	int code = hashCode(text.subString(0, M);

	if (code == hashCode && text.subString(0, M).equals(pattern)) return 0;
        
	final int N = text.length();
	for (int i = M; i < N; ++i) {
	    code = (code + SIZE - (text.charAt(i - M) * rm) % SIZE) % SIZE;
	    code = ((code * BASE) % SIZE + text.charAt(i)) % SIZE;

	    if (code == hashCode && text.subString(i, M).equals(pattern)) return i - M + 1;
	}

	return -1;
    }
}
