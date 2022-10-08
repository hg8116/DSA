// https://leetcode.com/problems/flood-fill/

package FloodFill733;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    // Using BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]) return image;
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int oldColor = image[sr][sc];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            image[r][c] = color;
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == oldColor) {
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        return image;
    }

    // Using DFS
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int n = image.length;
        int m = image[0].length;

        dfs(image, sr, sc, color, image[sr][sc], m, n);
        return image;
    }

    public void dfs(int[][] image, int currRow, int currCol, int color, int oldColor, int m, int n) {
        if (!(currRow >= 0 && currCol >= 0 && currRow < n && currCol < m && image[currRow][currCol] == oldColor))
            return;

        image[currRow][currCol] = color;
        dfs(image, currRow - 1, currCol, color, oldColor, m, n);
        dfs(image, currRow, currCol - 1, color, oldColor, m, n);
        dfs(image, currRow + 1, currCol, color, oldColor, m, n);
        dfs(image, currRow, currCol + 1, color, oldColor, m, n);
    }
}