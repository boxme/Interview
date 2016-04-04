package com.caarly.caarlymarketplace.app;

/**
 * Created by desmond on 15/6/15.
 */
public class AVL {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        insertNode(root, value);
    }

    public void delete(int value) {
        deleteNode(root, value);
    }

    public Node searchValue(int value) {
        return search(root, value);
    }

    public Node findMax() {
        return findMax(root);
    }

    public Node findMin() {
        return findMin(root);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (node.value > value) {
            node.left = insertNode(node.left, value);
            node.left.parent = node;
        } else {
            node.right = insertNode(node.right, value);
            node.right.parent = node;
        }

        return balanceNode(node);
    }

    private Node deleteNode(Node node, int value) {
        if (node == null) return null;

        if (node.value > value) {
            node.left = deleteNode(node.left, value);
        } else if (node.value < value) {
            node.right = deleteNode(node.right, value);
        } else {
            Node leftChild = node.left;
            Node rightChild = node.right;

            if (leftChild != null && rightChild != null) {
                Node newNode = findSuccessor(node.right);
                node.value = newNode.value;
                node.right = deleteNode(node.right, newNode.value);
            } else if (leftChild != null) {
                node.left = null;
                leftChild.parent = node.parent;
                node.parent = null;
                node = leftChild;
            } else if (rightChild != null) {
                node.right = null;
                rightChild.parent = node.parent;
                node.parent = null;
                node = rightChild;
            } else {
                // Node is a leaf
                node.parent = null;
                node = null;
                return node;
            }
        }

        return balanceNode(node);
    }

    private Node balanceNode(Node node) {
        int parentBalancedIndex = isBalanced(node);
        int leftBalancedIndex = isBalanced(node.left);
        int rightBalancedIndex = isBalanced(node.right);

        if (parentBalancedIndex == -2) {
            if (rightBalancedIndex == 1) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            } else if (rightBalancedIndex == -1) {
                return rotateLeft(node);
            }
        } else if (parentBalancedIndex == 2) {
            if (leftBalancedIndex == -1) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            } else if (leftBalancedIndex == 1) {
                return rotateRight(node);
            }
        }

        return node;
    }

    private Node findSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return findMin(node.right);
        } else {
            Node parent = node.parent;
            Node curr = node;

            while (parent != null) {
                if (parent.right == curr) {
                    curr = parent;
                    parent = curr.parent;
                } else {
                    // Made the right right turn
                    return parent;
                }
            }
        }

        return null;
    }

    private Node findPredecessor(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return findMax(node.left);
        } else {
            Node parent = node.parent;
            Node curr = node;

            while (parent != null) {
                if (parent.left == curr) {
                    curr = parent;
                    parent = curr.parent;
                } else {
                    // Made the first left turn
                    return parent;
                }
            }
        }
        return null;
    }

    private int getHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int isBalanced(Node root) {
        if (root == null) return 0;

        return getHeight(root.left) - getHeight(root.right);
    }

    private Node rotateLeft(Node node) {
        if (node == null) return null;

        Node rightChild = node.right;
        if (rightChild != null) {
            rightChild.parent = node.parent;
            node.parent = rightChild;
            if (rightChild.left != null) {
                rightChild.left.parent = node;
            }
            node.right = rightChild.left;
            rightChild.left = node;
        }

        return rightChild;
    }

    private Node rotateRight(Node node) {
        if (node == null) return null;

        Node leftChild = node.left;
        if (leftChild != null) {
            leftChild.parent = node.parent;
            node.parent = leftChild;
            if (leftChild.right != null) {
                leftChild.right.parent = node;
            }
            node.left = leftChild.right;
            leftChild.right = node;
        }

        return leftChild;
    }

    private Node findMax(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node;
        }

        return findMax(node.right);
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }

    private Node search(Node node, int value) {
        if (node == null) return null;

        if (node.value == value)     return node;
        else if (node.value > value) return search(node.left, value);
        else                         return search(node.right, value);
    }

    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }
}
