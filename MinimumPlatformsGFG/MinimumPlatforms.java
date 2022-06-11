// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

package MinimumPlatformsGFG;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0, j=0;
        int max=1, plat=1;

        while(i < n && j < n){
            if(arr[i] <= dep[i]){
                plat++;
                i++;
            }
            else if(arr[i] > dep[i]){
                plat--;
                j++;
            }
            if(max < plat){
                max = plat;
            }
        }

        return max;
    }
}
