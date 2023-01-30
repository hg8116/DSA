// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/

package FindClosestNodeToGivenTwoNodes2359;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        findDist(node1, dist1, edges);
        findDist(node2, dist2, edges);

        int dist = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int curr = Math.max(dist1[i], dist2[i]);
                if (dist > curr) {
                    dist = curr;
                    ans = i;
                }
            }
        }
        return ans;
    }

    void findDist(int source, int[] dist, int[] edges) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[edges.length];

        dist[source] = 0;
        q.add(source);
        int distance = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr != -1 && !vis[curr]) {
                dist[curr] = distance++;
                q.add(edges[curr]);
                vis[curr] = true;
            }
        }
    }
}
