import java.util.*;

class qn_9_4 {
    public static void main(String[] args) {

    }

    public static class BinaryTree {
        private BinaryTree left, right, parent;
        private boolean locked = false;
        private int numLockedDescendants = 0;
        
        public boolean isLock() { return locked; }
        
        public boolean lock() {
            if (numLockedDescendants > 0 || locked) {
                return false;
            }
            
            // Tests if any of ancestors are not locked.
            for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                if (iter.locked) {
                    return false;
                }
            }
            
            // Locks itself and increments its ancestors's lock counts.
            locked = true;
            for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                ++iter.numLockedDescendants;
            }
            return true;
        }
        
        public void unlock() {
            if (locked) {
                // Unlocks itself and decrements its ancestors's lock counts.
                locked = false;
                for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                    --iter.numLockedDescendants;
                }
            }
        }
        // @exclude
        
        public BinaryTree getLeft() { return left; }
        
        public void setLeft(BinaryTree left) { this.left = left; }
        
        public BinaryTree getRight() { return right; }
        
        public void setRight(BinaryTree right) { this.right = right; }
        
        public void setParent(BinaryTree parent) { this.parent = parent; }
        // @include
    }
}
