// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

package NumbersWithSameConsecutiveDifferences967;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            return new int[]{0};
        }

        for (int i = 1; i <= 9; i++) {
            dfs(i, n - 1, k, list);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    void dfs(int i, int n, int k, List<Integer> list) {
        if (n == 0) {
            list.add(i);
            return;
        }

        int last = i % 10;
        if (last >= k) dfs(i * 10 + last - k, n - 1, k, list);
        if (k > 0 && last + k < 10) dfs(i * 10 + last + k, n - 1, k, list);
    }
}
