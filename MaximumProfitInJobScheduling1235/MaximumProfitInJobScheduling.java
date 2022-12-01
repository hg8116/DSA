// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

package MaximumProfitInJobScheduling1235;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    class Job implements Comparable<Job> {
        int start, end, pro;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            pro = p;
        }

        public int compareTo(Job o) {
            return start - o.start;
        }
    }

    int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        Job[] job = new Job[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            job[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(job);

        return helper(job, 0, dp);
    }

    int helper(Job[] job, int i, int[] dp) {
        if (i >= n)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int next = findNextJob(job, i + 1, job[i].end);
        int taken = job[i].pro + helper(job, next, dp);
        int notTaken = helper(job, i + 1, dp);

        return dp[i] = Math.max(taken, notTaken);
    }

    int findNextJob(Job[] job, int l, int target) {
        int r = n - 1;
        int ans = n + 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (job[mid].start >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}