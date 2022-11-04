// https://leetcode.com/problems/where-will-the-ball-fall/

package WhereWillTheBallFall1706;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = helper(grid, 0, i);
        }
        return ans;
    }

    int helper(int[][] grid, int i, int j) {
        int n = grid[0].length;
        if (i == grid.length)
            return j;
        if (j < 0 || j > n)
            return -1;
        if (j < n - 1 && grid[i][j] == 1 && grid[i][j + 1] == 1)
            return helper(grid, i + 1, j + 1);
        else if (j > 0 && grid[i][j] == -1 && grid[i][j - 1] == -1)
            return helper(grid, i + 1, j - 1);
        return -1;
    }
}
