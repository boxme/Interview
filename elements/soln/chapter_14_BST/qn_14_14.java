import java.util.*;

class qn_14_14 {

    public static boolean findAncestorNDescendentOfM(Node r, Node s, Node m) {
        Node searchR = r;
        Node searchS = s;

        while (searchR != s && searchR != m 
                && searchS != r && searchS != m 
                && (searchR != null || searchS != null)) {
                
            if (searchR != null) {
                searchR = searchR.value > m.value ? searchR.left : searchR.right;
            }

            if (searchS != null) {
                searchS = searchS.value > m.value ? searchS.left : searchS.right;
            }
        }

        // Both searches are unsuccessful in find a path to m from either r & s
        if (searchR == s || searchS == m || (searchR != m && searchS != m)) {
            return false;
        }

        return searchR == m ? searchTarget(m, searchS) : searchTarget(m, searchM); 
    }

    // Search for a possible path from m to node
    public static boolean searchTarget(Node m, Node node) {
        while (m != null && node != m) {
            m = m.value > node.value ? m.left : m.right;
        }

        return m == node;
    }

    class Node {
        int value;
        Node left;
        Node right;
    }
}
