// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/description/

package CheckingExistenceOfEdgeLengthLimitedPaths1697;

import java.util.Arrays;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] < rank[py])
                    parent[px] = py;
                else if (rank[px] > rank[py])
                    parent[py] = px;
                else {
                    parent[py] = px;
                    rank[px]++;
                }
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        for (int i = 0; i < queries.length; i++)
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        boolean[] ans = new boolean[queries.length];
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        UnionFind obj = new UnionFind(n);
        int i = 0;
        for (int[] q : queries) {
            int u = q[0], v = q[1], lim = q[2], id = q[3];
            while (i < edgeList.length && edgeList[i][2] < lim) {
                obj.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            ans[id] = obj.connected(u, v);
        }
        return ans;
    }
}
