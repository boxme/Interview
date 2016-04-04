import java.util.*;

class qn_14_9 {

    public static BSTNode<Integer> bstToDoublyLinkedList(BSTNode<Integer> tree) {
        // Empty subtree.
        if (tree == null) {
            return null;
        }
        
        // Recursively build the list from left and right subtrees.
        BSTNode<Integer> lHead = bstToDoublyLinkedList(tree.getLeft());
        BSTNode<Integer> rHead = bstToDoublyLinkedList(tree.getRight());
        
        // Append tree to the list from left subtree.
        BSTNode<Integer> lTail = null;
        if (lHead != null) {
            lTail = lHead.getLeft();
            lTail.setRight(tree);
            tree.setLeft(lTail);
            lTail = tree;
        } else {
            lHead = lTail = tree;
        }
        
        // Append the list from right subtree to tree.
        BSTNode<Integer> rTail = null;
        if (rHead != null) {
            rTail = rHead.getLeft();
            lTail.setRight(rHead);
            rHead.setLeft(lTail);
        } else {
            rTail = lTail;
        }
        rTail.setRight(lHead);
        lHead.setLeft(rTail);
        
        return lHead;
    }

    class Node {
        int value;
        Node prev;
        Node next;
    }
}
