import java.util.*;

class qn_9_14 {
    public static void main(String[] args) {

    }
    
    public class Trie {

        private TrieNode root = new TrieNode();
        
        // Returns true if the string is inserted, else the trie already contains the string
        public boolean insert(String s) {
            TrieNode p = root;
            for (char c : s.toCharArray()) {
                if (!p.getLeaves().containsKey(c)) {
                    p.getLeaves().put(c, new TrieNode());
                }
                p = p.getLeaves().get(c);
            }

            if (p.getIsString()) {
                // String s already existed in this Trie
                return false;
            } else {
                p.setIsString(true);
                return true;
            }
        }

        public String getShortestUniquePrefix(String s) {
            TrieNode p = root;
            StringBuilder prefix = new StringBuilder();

            for (char c : s.toCharArray()) {
                prefix.append(c);
                if (!p.getLeaves().containsKey(c)) {
                    return prefix.toString();
                }
                p = p.getLeaves().get(c);
            }

            // Entire string s is a prefix in one of the words in the trie
            return "";
        }

        private static class TrieNode {
            private boolean isString = false;
            // Direct decendents of the current node
            private Map<Character, TrieNode> leaves = new HashMap<Character, TrieNode>();

            public boolean getIsString() {
                return isString;
            }

            public void setIsString(boolean isString) {
                this.isString = isString;
            }

            public Map<Character, TrieNode> getLeaves() {
                return leaves;
            }
        }
    }
}
