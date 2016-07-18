import java.util.*;

public class qn_8_3 {
    public void printBstInBFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node curr;
        boolean isRoot = true;
        while (!q.isEmpty()) {
            curr = q.poll();
            System.out.print(isRoot ? curr.value : " " + curr.value);
            isRoot = false;
            q.offer(curr.left);
            q.offer(curr.right);
        }
    }
}

private class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
