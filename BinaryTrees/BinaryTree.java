package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BT{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    /*
    Preorder traversal of binary tree -
    1) root
    2) left child
    3) right child
    */

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /*
    Inorder traversal of binary tree -
    1) left child
    2) root
    3) right child
    */

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /*
    Postorder traversal of binary tree -
    1) left child
    2) right child
    3) root
    */

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    /*
    Level order traversal of binary tree -
    Traversing the tree level wise, using queue to store data temporarily.
    */

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    // Counting the number of nodes in binary tree
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    // Finding the sum of nodes in binary tree
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // Finding the height of binary tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;

        return myHeight;
    }

    // Finding the diameter of binary tree

    // Method 1 -
    // TC - O(n^2)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max(dia3, Math.max(dia1, dia2));
    }

    // Method 2 -
    // TC - O(n)
    static class TreeInfo{
        int ht;
        int dia;

        TreeInfo(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int maxHeight = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;

        int maxDia = Math.max(Math.max(dia1, dia2), dia3);
        return new TreeInfo(maxHeight, maxDia);
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BT tree = new BT();
        Node root = tree.buildTree(nodes);
//        System.out.println(root.data);
//        preorder(root);
//        inorder(root);
//        postorder(root);
//        levelOrder(root);
        System.out.println(diameter2(root).dia);
    }
}
