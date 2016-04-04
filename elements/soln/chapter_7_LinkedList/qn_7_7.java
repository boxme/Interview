import java.util.*;

class qn_7_7 {

    // Assume node to delete is not tail
    public void deleteFromList(Node nodeToDelete) {
        nodeToDelete.value = nodeToDelete.next.value;
        nodeToDelete.next = nodeToDelete.next.next;
        nodeToDelete.next = null;
    }

    Node {
        int value;
        Node next;
    }
}
