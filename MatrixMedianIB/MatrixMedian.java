// https://www.interviewbit.com/problems/matrix-median/

package MatrixMedianIB;

import java.util.ArrayList;

public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> arr){
        int n = arr.size();
        if(n == 0) return -1;
        int m = arr.get(0).size();
        int lo = 0, hi = Integer.MAX_VALUE;
        int x = 1;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isLessThanHalf(arr, mid)){
                lo = mid + 1;
            }
            else{
                x = mid;
                hi = mid - 1;
            }
        }
        return x;
    }

    public boolean isLessThanHalf(ArrayList<ArrayList<Integer>> arr, int num){
        int n = arr.size();
        int m = arr.get(0).size();
        int count = 0;

        for(int i=0; i<n; i++){
            count += getCount(arr.get(i), num);
        }
        return count < (n * m) / 2 + 1;
    }

    public int getCount(ArrayList<Integer> arr, int num){
        int lo = 0;
        int hi = arr.size() - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr.get(mid) > num) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

}
