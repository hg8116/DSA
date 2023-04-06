// https://leetcode.com/problems/number-of-closed-islands/description/

package NumberOfClosedIslands1254;

public class NumberOfClosedIslands {
    int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid))
                        ans++;
                }
            }
        }

        return ans;
    }

    boolean dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return false;
        if (grid[x][y] == 1)
            return true;
        grid[x][y] = 1;
        boolean ans = true;
        for (int[] coord : dir) {
            ans = ans & dfs(x + coord[0], y + coord[1], grid);
        }

        return ans;
    }
}
