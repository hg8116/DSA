// https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1

package DuplicateSubtreeInBinaryTreeGFG;

import java.util.HashSet;

public class DuplicateSubtreeInBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int dupSub(Node root) {
        HashSet<String> hs = new HashSet<>();

        return hasDuplicateSubtree(root, "", hs).equals("F") ? 1 : 0;
    }

    String hasDuplicateSubtree(Node root, String s, HashSet<String> hs){
        if(root == null) return "$";
        if(root.left == null && root.right == null) return root.data + "*";

        String sub = root.data + "*";
        String ltree = hasDuplicateSubtree(root.left, s, hs);
        if(ltree.equals("F")) return "F";

        sub += ltree;

        String rtree = hasDuplicateSubtree(root.right, s, hs);
        if(rtree.equals("F")) return "F";

        sub += rtree;
        if (hs.contains(sub)) return "F";
        else hs.add(sub);

        return sub + "*";
    }
}
