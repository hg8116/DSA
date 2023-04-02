// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

package SuccessfulPairsOfSpellsAndPotions2300;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = m - find(spells[i], potions, success);
        }

        return ans;
    }

    int find(int spell, int[] potions, long success) {
        int start = 0, end = potions.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long product = (long) spell * potions[mid];
            if (product >= success)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }
}
