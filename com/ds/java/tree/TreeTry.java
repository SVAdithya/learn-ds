package com.ds.java.tree;

public class TreeTry {
    static Node root ;
    public static void main(String[] args) {
        root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 3);
        root = insert(root, 9);
        root = insert(root, 8);
        root = insert(root, 6);
        root = insert(root, 7);
        root = insert(root, 5);
        root = insert(root, 11);
        root = insert(root, 10);
        root = insert(root, 13);
        printRootToLeaftPaths(root, "");
        delete(root,4);
        printRootToLeaftPaths(root, "");

        System.out.println("\nPre-order traversal:");
        preOrder(root);

        System.out.println("\nIn-order traversal:");
        inOrder(root);

        System.out.println("\nPost-order traversal:");
        postOrder(root);
        System.out.println("\n Height of the tree: " + maxDepth(root));
        System.out.println("Root to Leaf paths:");
        printRootToLeaftPaths(root, "");
    }
    public static Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // Node found
            if (node.left == null && node.right == null) {
                return null; // Case: no children
            } else if (node.left == null) {
                return node.right; // Case: only right child
            } else if (node.right == null) {
                return node.left; // Case: only left child
            } else {
                // Case: two children
                // Find inorder successor (minimum value in right subtree)
                Node successor = node.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                node.data = successor.data;
                node.right = delete(node.right, successor.data);
            }
        }
        return node;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void printRootToLeaftPaths(Node root, String path) {
        if (root == null) {
            return;
        } else {
            path += root.data;
            if (root.left == null && root.right == null) {
                System.out.println(path);
            } else {
                printRootToLeaftPaths(root.left, path+"-L-");
                printRootToLeaftPaths(root.right, path+"-R-");
            }
        }
    }

}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}