// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/

package DifferenceBetweenOnesAndZerosInRowAndColumn2482;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] diff = new int[n][m];

        int[] rowZero = new int[n];
        int[] colZero = new int[m];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
            rowZero[i] = count;
        }


        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 0)
                    count++;
            }
            colZero[i] = count;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = (n - rowZero[i] + m - colZero[j]) - (rowZero[i] + colZero[j]);
            }
        }

        return diff;


    }
}
