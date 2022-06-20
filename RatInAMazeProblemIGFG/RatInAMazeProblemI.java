// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

package RatInAMazeProblemIGFG;

import java.util.ArrayList;

public class RatInAMazeProblemI {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        solve(0, 0, n, m, new StringBuilder(""), ans);

        return ans;
    }

    public static void solve(int i, int j, int n, int[][] m, StringBuilder sb, ArrayList<String> ans){
        if(i < 0 || j < 0 || i == n || j == n || m[i][j] == 0){
            return;
        }
        if(i == n - 1 && j == n - 1){
            ans.add(sb.toString());
            return;
        }

        m[i][j] = 2;
        solve(i + 1, j, n, m, sb.append("D"), ans);
        sb = sb.deleteCharAt(sb.length() - 1);
        solve(i - 1, j, n, m, sb.append("U"), ans);
        sb = sb.deleteCharAt(sb.length() - 1);
        solve(i, j + 1, n, m, sb.append("R"), ans);
        sb = sb.deleteCharAt(sb.length() - 1);
        solve(i, j - 1, n, m, sb.append("L"), ans);
        sb = sb.deleteCharAt(sb.length() - 1);
        m[i][j] = 1;
    }
}
