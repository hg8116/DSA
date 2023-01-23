// https://leetcode.com/problems/find-the-town-judge/

package FindTheTownJudge997;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n + 1];
        for (int[] x : trust) {
            trusted[x[0]]--;
            trusted[x[1]]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (trusted[i] == n - 1)
                return i;
        }
        return -1;
    }
}
