import java.util.*;

public class qn_8_3 {
    public void printBstInDFS(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr;
        while (!root.isEmpty()) {
            curr = root.peek();
            if (curr.left != null && !curr.left.visited) {
                root.left.visited = true;
                root.push(curr);
            } else {
                System.out.print(curr.value + " ");
                if (curr.right != null && !curr.right.visited) {
                    curr.right.visited = true;
                    root.push(curr.right);
                } else {
                    root.pop();
                }
            }
        }
    }
}

private class Node {
    int value;
    Node left;
    Node right;
    boolean visited;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
