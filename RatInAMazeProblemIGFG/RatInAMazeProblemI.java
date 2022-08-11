// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

package RatInAMazeProblemIGFG;

import java.util.ArrayList;

public class RatInAMazeProblemI {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 0) {
            ans.add("-1");
            return ans;
        }
        int[][] vis = new int[n][n];

        dfs(m, n, 0, 0, vis, "", ans);
        return ans;
    }

    static void dfs(int[][] m, int n, int i, int j, int[][] vis, String s, ArrayList<String> ans) {
        if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }

        // Down
        if (i + 1 < n && vis[i + 1][j] == 0 && m[i + 1][j] == 1) {
            vis[i][j] = 1;
            dfs(m, n, i + 1, j, vis, s + "D", ans);
            vis[i][j] = 0;
        }

        // Left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && m[i][j - 1] == 1) {
            vis[i][j] = 1;
            dfs(m, n, i, j - 1, vis, s + "D", ans);
            vis[i][j] = 0;
        }

        // Right
        if (j + 1 < n && vis[i][j + 1] == 0 && m[i + 1][j + 1] == 1) {
            vis[i][j] = 1;
            dfs(m, n, i, j + 1, vis, s + "D", ans);
            vis[i][j] = 0;
        }

        // Up
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && m[i - 1][j] == 1) {
            vis[i][j] = 1;
            dfs(m, n, i - 1, j, vis, s + "D", ans);
            vis[i][j] = 0;
        }
    }

    // Shorter Method
    public static ArrayList<String> findPath2(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 0) {
            ans.add("-1");
            return ans;
        }
        int[][] vis = new int[n][n];

        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};

        dfs2(m, n, 0, 0, vis, "", ans, di, dj);
        return ans;
    }

    static void dfs2(int[][] m, int n, int i, int j, int[][] vis, String s, ArrayList<String> ans, int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }
        String dir = "DLRU";

        for (int ind = 0; ind < 4; i++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && m[nexti][nextj] == 1) {
                vis[i][j] = 1;
                dfs2(m, n, nexti, nextj, vis, s + dir.charAt(ind), ans, di, dj);
                vis[i][j] = 0;
            }
        }

    }
}
