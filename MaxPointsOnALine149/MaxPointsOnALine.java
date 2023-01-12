// https://leetcode.com/problems/max-points-on-a-line/

package MaxPointsOnALine149;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    // Brute Force
    // TC - O(n^3)
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;

        if (n == 1)
            return 1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx1 = points[j][0] - points[i][0];
                int dy1 = points[j][1] - points[i][1];
                int count = 2;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        int dx2 = points[k][0] - points[i][0];
                        int dy2 = points[k][1] - points[i][1];
                        if (dy1 * dx2 == dx1 * dy2)
                            count++;
                    }
                }

                ans = Math.max(count, ans);
            }
        }
        return ans;
    }

    // Using Map
    // TC - O(n^2)
    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n;

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                map.put(dx + " " + dy, map.getOrDefault(dx + " " + dy, 0) + 1);
                max = Math.max(max, map.get(dx + " " + dy));
            }
            ans = Math.max(ans, max + duplicate + 1);
        }

        return ans;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
