// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

package NaryTreeLevelOrderTraversal429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                sub.add(curr.val);
                for (int j = 0; j < curr.children.size(); j++) {
                    q.add(curr.children.get(j));
                }
            }
            ans.add(sub);
        }

        return ans;
    }
}
