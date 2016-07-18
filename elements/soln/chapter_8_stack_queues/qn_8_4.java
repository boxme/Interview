import java.util.*;

// Iterative solution to a jump-first order for a posting list
public class qn_8_4 {
    
    public void jumpFirstOrderInPostingList(Node head) {
        Stack<Node> stack = new Stack<>();
        head.order = 0;
        stack.push(order);
        Node curr;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (curr.jump != null && curr.jump.order == -1) {
                Node jump = curr.jump;
                jump.order = curr.order + 1;
                stack.push(jump);
            } else if (curr.next != null && curr.next.order == -1) {
                Node next = curr.next;
                next.order = curr.order + 1;
                stack.push(next);
            } else {
                stack.pop();
            }
        }
    }
}

private class Node {
    int value;
    Node next;
    Node jump;
    int order;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.jump = null;
        this.order = -1;
    }
}
