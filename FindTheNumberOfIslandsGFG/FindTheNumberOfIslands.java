// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

package FindTheNumberOfIslandsGFG;

public class FindTheNumberOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }

        return ans;
    }

    int[] drow = {-1, 0, 1, 0, -1, 1, 1, -1};
    int[] dcol = {0, -1, 0, 1, -1, -1, 1, 1};

    void dfs(int i, int j, char[][] grid){
        grid[i][j] = '0';
        for(int x=0; x<8; x++){
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == '1')
                dfs(nrow, ncol, grid);
        }
    }
}
