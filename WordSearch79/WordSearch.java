// https://leetcode.com/problems/word-search/

package WordSearch79;

public class WordSearch {
    boolean[][] vis;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j] && search(i, j, 0, word, board))
                    return true;
            }
        }

        return false;
    }

    boolean search(int i, int j, int index, String word, char[][] board) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || vis[i][j])
            return false;

        vis[i][j] = true;
        if (search(i + 1, j, index + 1, word, board) ||
                search(i - 1, j, index + 1, word, board) ||
                search(i, j + 1, index + 1, word, board) ||
                search(i, j - 1, index + 1, word, board))
            return true;

        vis[i][j] = false;
        return false;
    }
}