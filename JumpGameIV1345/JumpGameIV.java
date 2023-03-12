// https://leetcode.com/problems/jump-game-iv/description/

package JumpGameIV1345;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n - 1)
                    return ans;
                List<Integer> temp = adj.get(arr[curr]);
                temp.add(curr - 1);
                temp.add(curr + 1);
                for (int x : temp) {
                    if (x >= 0 && x < n && !vis[x]) {
                        q.add(x);
                        vis[x] = true;
                    }
                }
                temp.clear();
            }
            ans++;
        }

        return -1;
    }
}
