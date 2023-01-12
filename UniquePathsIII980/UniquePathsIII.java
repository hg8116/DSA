// https://leetcode.com/problems/unique-paths-iii/

package UniquePathsIII980;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int sx = 0;
        int sy = 0;
        int zeroes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    zeroes++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }

        return helper(sx, sy, zeroes, grid);
    }

    int helper(int i, int j, int zeroes, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == -1)
            return 0;
        if (grid[i][j] == 2 && zeroes == -1)
            return 1;
        if (grid[i][j] == 2)
            return 0;

        grid[i][j] = -1;
        zeroes--;

        int totalPaths = helper(i + 1, j, zeroes, grid) +
                helper(i, j + 1, zeroes, grid) +
                helper(i - 1, j, zeroes, grid) +
                helper(i, j - 1, zeroes, grid);

        grid[i][j] = 0;
        zeroes++;

        return totalPaths;
    }
}
