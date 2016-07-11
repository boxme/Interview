import java.util.*;

// Regular expression matching
public class qn_6_23 {
    public boolean regularExpression(String r, String s) {
        if (r.charAt(0) == '^') {
            return match(r.subString(1), s);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (match(r, s.subString(i))) return true;
        }

        return false;
    }

    private boolean match(String r, String s) {
        if (r.isEmpty()) return true;

        char c = r.charAt(0);
        if (c == '$') {
            return s.isEmpty();
        }

        if (s.isEmpty()) return false;

        int len = r.length();
        if (len >= 2 && r.charAt(1) == '*') {
            for (int i = 0; i < s.length() && (c == '.' || s.charAt(i) == c); ++i) {
                if (match(r.subString(2), s.subString(i+1))) return true;
            }

            return match(r, s.subString(2));
        }

        return (c == '.' || c == '*' || s.charAt(0) == c) && match(r.subString(1), s.subString(1));
    }
}
