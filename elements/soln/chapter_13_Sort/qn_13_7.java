import java.util.*;

class qn_13_7 {
    public void countOccurences(String string) {
        char[] a = string.toCharArray();
        Arrays.sort(a);

        int currentCharacterCount  = 1;
        for (int i = 1; i < a.length; ++i) {
            if (a[i - 1] == a[i]) {
                currentCharacterCount++;
            } else {
                System.out.print("(" + a[i-1] + ", " + currentCharacterCount + ")");
                currentCharacterCount = 1;
            }
        }
    
        System.out.println("(" + a[a.length - 1] + ", " + currentCharacterCount + ")");
    }
}
