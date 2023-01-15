// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

package LongestPathWithDifferentAdjacentCharacters2246;

import java.util.ArrayList;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {
    int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 1; i < parent.length; i++) {
            adj.get(parent[i]).add(i);
            adj.get(i).add(parent[i]);
        }

        ans = 0;
        dfs(0, -1, adj, s);
        return ans;
    }

    int dfs(int cur, int par, List<List<Integer>> adj, String s) {
        int longest = 0;
        int secondLongest = 0;

        for (Integer it : adj.get(cur)) {
            if (it == par)
                continue;

            int childLongest = dfs(it, cur, adj, s);
            if (s.charAt(cur) == s.charAt(it))
                continue;

            if (childLongest > secondLongest)
                secondLongest = childLongest;
            if (secondLongest > longest) {
                int temp = secondLongest;
                secondLongest = longest;
                longest = temp;
            }
        }

        int single = Math.max(longest, secondLongest) + 1;
        int rootOnly = 1;
        int childOnly = longest + secondLongest + 1;

        ans = Math.max(Math.max(single, rootOnly), Math.max(childOnly, ans));

        return Math.max(single, rootOnly);
    }
}
