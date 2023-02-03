// https://leetcode.com/problems/best-team-with-no-conflicts/

package BestTeamWithNoConflicts1626;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
    class Player {
        public int age, score;

        Player(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++)
            players[i] = new Player(ages[i], scores[i]);

        Arrays.sort(players, (a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = players[i].score;
            for (int j = 0; j < i; j++) {
                if (players[j].score <= players[i].score)
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
