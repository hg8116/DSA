// https://leetcode.com/problems/edit-distance/description/

package EditDistance72;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] mat = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++)
            mat[0][i] = i;
        for (int i = 0; i <= n; i++)
            mat[i][0] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    mat[i + 1][j + 1] = mat[i][j];
                else {
                    int replace = mat[i][j];
                    int delete = mat[i + 1][j];
                    int insert = mat[i][j + 1];
                    mat[i + 1][j + 1] = 1 + Math.min(Math.min(delete, insert), replace);
                }
            }
        }

        return mat[n][m];
    }
}
