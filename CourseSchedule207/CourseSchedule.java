// https://leetcode.com/problems/course-schedule/

package CourseSchedule207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] x: pre){
            adj.get(x[1]).add(x[0]);
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            i++;
            for (Integer it : adj.get(curr)) {
                if (--indegree[it] == 0)
                    q.add(it);
            }
        }

        if (i == n)
            return true;
        return false;
    }
}
