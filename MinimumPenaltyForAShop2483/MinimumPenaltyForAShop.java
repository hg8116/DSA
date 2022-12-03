// https://leetcode.com/problems/minimum-penalty-for-a-shop/

package MinimumPenaltyForAShop2483;

public class MinimumPenaltyForAShop {
    public int bestClosingTime(String str) {
        int n = str.length();
        int[] leftN = new int[n + 1];
        int[] rightY = new int[n + 1];

        int countY = 0, countN = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'N')
                countN++;
            leftN[i + 1] = countN;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'Y')
                countY++;
            rightY[i + 1] = countY;
        }

        int minInd = 0;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < n)
                ans[i] = rightY[i + 1] + leftN[i];
            else
                ans[n] = leftN[n];
            if (ans[minInd] > ans[i])
                minInd = i;

        }

        return minInd;
    }
}
