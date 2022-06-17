// https://leetcode.com/problems/binary-tree-cameras/

package BinaryTreeCameras968;

public class BinaryTreeCameras {
    int cam = 0;
    public int minCameraCover(TreeNode root) {
        int ans = dfs(root);
        return ans == 0 ? cam + 1 : cam;
    }

    public int dfs(TreeNode node){
        if(node == null) return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);

        if(left == 0 || right == 0){
            cam++;
            return 2;
        }
        else if(left == 2 || right == 2) return 1;
        else return 0;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode val;
    }
}
