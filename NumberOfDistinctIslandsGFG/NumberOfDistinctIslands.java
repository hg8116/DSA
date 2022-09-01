// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

package NumberOfDistinctIslandsGFG;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    ArrayList<String> sub = new ArrayList<>();
                    dfs(i, j, grid, sub, i, j);
                    set.add(sub);
                }
            }
        }

        return set.size();
    }

    String toString(int i, int j){
        return i + " " + j;
    }

    int[] drow = {-1, 0, +1, 0};
    int[] dcol = {0, -1, 0, +1};

    void dfs(int i, int j, int[][] grid, ArrayList<String> sub, int bi, int bj){
        grid[i][j] = 0;
        sub.add(toString(i - bi, j - bj));
        for(int x=0; x<4; x++){
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, sub, bi, bj);
            }
        }
    }
}
