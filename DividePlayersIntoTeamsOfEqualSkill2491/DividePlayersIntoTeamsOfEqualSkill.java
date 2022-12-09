// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/

package DividePlayersIntoTeamsOfEqualSkill2491;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int total = 0;
        for (int i = 0; i < n; i++)
            total += skill[i];

        int totalTeams = n / 2;
        if (total % totalTeams != 0) return -1;

        int single = total / totalTeams;
        System.out.println(single);

        long ans = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (skill[i] + skill[j] != single)
                return -1;
            ans += skill[i] * skill[j];
            i++;
            j--;
        }

        return ans;
    }
}
