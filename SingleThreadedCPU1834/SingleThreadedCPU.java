// https://leetcode.com/problems/single-threaded-cpu/

package SingleThreadedCPU1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    class Task {
        int start, time, index;

        Task(int s, int t, int i) {
            start = s;
            time = t;
            index = i;
        }
    }

    public class Duration implements Comparator<Task> {
        @Override
        public int compare(Task one, Task two) {
            if (one.time == two.time)
                return one.index - two.index;
            return one.time - two.time;
        }
    }

    public class StartTime implements Comparator<Task> {
        @Override
        public int compare(Task one, Task two) {
            return one.start - two.start;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        Task[] task = new Task[n];

        for (int i = 0; i < n; i++) {
            Task x = new Task(tasks[i][0], tasks[i][1], i);
            task[i] = x;
        }

        Arrays.sort(task, new StartTime());

        PriorityQueue<Task> pq = new PriorityQueue<>(new Duration());
        int ansInd = 0;
        int currInd = 0;
        int currTime = 0;
        while (ansInd < n) {
            while (currInd < n && task[currInd].start <= currTime)
                pq.add(task[currInd++]);
            if (pq.size() == 0) {
                currTime = task[currInd].start;
                continue;
            }
            Task bestFit = pq.poll();
            ans[ansInd++] = bestFit.index;
            currTime += bestFit.time;
        }

        return ans;
    }
}
