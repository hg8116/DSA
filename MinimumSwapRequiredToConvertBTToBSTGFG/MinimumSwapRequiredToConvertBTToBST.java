// https://practice.geeksforgeeks.org/problems/minimum-swap-required-to-convert-binary-tree-to-binary-search-tree/0?page=1&sortBy=newest&query=page1sortBynewest

package MinimumSwapRequiredToConvertBTToBSTGFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinimumSwapRequiredToConvertBTToBST {
    public static int minSwaps(int n, int[] A) {
        ArrayList<Integer> inorder = new ArrayList<>();
        findInorder(A, inorder, n, 0);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(inorder.get(i), i);
        }

        Collections.sort(inorder);
        int ans = 0;
        for(int i=0; i<n; i++){
            if(map.get(inorder.get(i)) != i){
                ans++;
                Collections.swap(inorder, map.get(inorder.get(i)), i);
                i--;
            }
        }

        return ans;
    }

    public static void findInorder(int[] nums, ArrayList<Integer> inorder, int n, int i){
        if(i >= n){
            return;
        }

        findInorder(nums, inorder, n, 2 * i + 1);
        inorder.add(nums[i]);
        findInorder(nums, inorder, n, 2 * i + 2);
    }
}
