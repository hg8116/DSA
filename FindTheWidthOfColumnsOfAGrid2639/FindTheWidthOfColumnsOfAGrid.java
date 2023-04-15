// https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/description/

package FindTheWidthOfColumnsOfAGrid2639;

public class FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, countDigit(grid[j][i]));
            }

            ans[i] = max;
        }

        return ans;
    }

    int countDigit(int num) {
        int count = 0;
        if (num <= 0) {
            count++;
            num *= -1;
        }

        while (num > 0) {
            num = num / 10;
            count++;
        }

        return count;
    }
}
