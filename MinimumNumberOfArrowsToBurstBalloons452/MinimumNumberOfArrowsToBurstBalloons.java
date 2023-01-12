// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

package MinimumNumberOfArrowsToBurstBalloons452;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 1;
        int curr = points[0][1];
        for(int i=1; i<points.length; i++){
            if(curr < points[i][0]){
                ans++;
                curr = points[i][1];
            }
        }
        return ans;
    }
}
