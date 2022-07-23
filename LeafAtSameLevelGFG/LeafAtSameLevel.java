// https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1

package LeafAtSameLevelGFG;

import java.util.ArrayList;

public class LeafAtSameLevel {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    boolean check(Node root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        ArrayList<Integer> list = new ArrayList<>();
        check(root, list, 0);

        for(int i=0; i<list.size() - 1; i++){
            if(list.get(i) != list.get(i+1)){
                return false;
            }
        }

        return true;
    }

    void check(Node root, ArrayList<Integer> list, int height){
        if(root.left == null && root.right == null){
            list.add(height);
            return;
        }

        if(root.left != null) check(root, list, height + 1);
        if(root.right != null) check(root, list, height + 1);
    }
}
