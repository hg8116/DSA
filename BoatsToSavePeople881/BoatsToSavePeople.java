// https://leetcode.com/problems/boats-to-save-people/description/

package BoatsToSavePeople881;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit)
                i++;
            j--;
            ans++;
        }

        return ans;
    }
}
