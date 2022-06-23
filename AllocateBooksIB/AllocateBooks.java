// interviewbit.com/problems/allocate-books/

package AllocateBooksIB;

import java.util.ArrayList;

public class AllocateBooks {
    public static int books(ArrayList< Integer > A, int B){
        if(B > A.size()) return -1;
        int low = A.get(0);
        int high = 0;
        for(int i=0; i<A.size(); i++){
            high += A.get(i);
            low = Math.min(low, A.get(i));
        }
        int res = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(A, mid, B)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isPossible(ArrayList<Integer> A, int pages, int students){
        int cnt = 0;
        int sumAllocated = 0;
        for(int i=0; i<A.size(); i++){
            if(sumAllocated + A.get(i) > pages){
                cnt++;
                sumAllocated = A.get(i);
                if(sumAllocated > pages) return false;
            }
            else{
                sumAllocated += A.get(i);
            }
        }
        if(cnt < students) return true;
        return false;
    }
}
