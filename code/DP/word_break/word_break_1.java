import java.util.*;

/**
    Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
 
 Given s = "lintcode", dict = ["lint", "code"].
 Return true because "lintcode" can be break as "lint code".
**/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j >= 0; --j) {
                if (dp[j] && dict.contains(s.substring(j, i + 1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}