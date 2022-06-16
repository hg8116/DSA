// https://practice.geeksforgeeks.org/problems/subset-sums2234/1

package SubsetSumsGFG;

import java.util.ArrayList;

public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res = new ArrayList<>();
        func(0, 0, N, arr, res);

        return res;
    }

    void func(int ind, int sum, int n, ArrayList<Integer> arr, ArrayList<Integer> res){
        if(ind == n){
            res.add(sum);
            return;
        }

        func(ind + 1, sum + arr.get(ind), n, arr, res);
        func(ind + 1, sum, n, arr, res);
    }
}
