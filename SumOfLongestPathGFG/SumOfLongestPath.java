// https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1

package SumOfLongestPathGFG;

public class SumOfLongestPath {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    int maxSum = 0;
    int maxLen = 0;

    public int sumOfLongRootToLeafPath(Node root){
        if(root == null) return 0;

        findHeight(root, 0, 0);
        return maxSum;
    }

    public void findHeight(Node root, int sum, int len){
        if(root == null){
            if(maxLen < len){
                maxLen = len;
                maxSum = sum;
            }
            else if(maxLen == len && maxSum < sum) maxSum = sum;
            return;
        }

        findHeight(root.left, sum + root.data, len + 1);
        findHeight(root.right, sum + root.data, len + 1);
    }
}
