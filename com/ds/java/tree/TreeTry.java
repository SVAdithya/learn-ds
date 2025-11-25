package com.ds.java.tree;

public class TreeTry {
    static Node root ;
    public static void main(String[] args) {
        root = insertBulk(root, 50,40,70,30,45,60,80,55,65,75,90,54,56,63,66,74,76,89,91);

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

        Node n = leftRotate(root);
        printRootToLeaftPaths(n, "");
    }

    public static Node leftRotate (Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // Perform rotation
        x.left =  y;
        y.right = T2;

        return x;
    }

    public static Node rightRotate (Node x) {
        Node y = x.left;
        Node T2 = y.right;

        // Perform rotation
        y.right =  x;
        x.left = T2;

        return y;
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

    public static Node insertBulk(Node node, int ...values) {
        for (int value : values) {
            node = insert(node, value);
        }
        return node;
    }

    public static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
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

    public static void printRootToLeaftPaths(Node node, String path) {
        if (node == null) {
            return;
        } else {
            path += node.data;
            if (node.left == null && node.right == null) {
                System.out.println(path);
            } else {
                printRootToLeaftPaths(node.left, path+"-L-");
                printRootToLeaftPaths(node.right, path+"-R-");
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