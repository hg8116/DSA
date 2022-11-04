package PrintingSubsequences;

import java.util.ArrayList;

public class Main {

    // TC - O(2^n * n)
    // SC - O(n)
    static void printSubsequence(int ind, int[] arr, ArrayList<Integer> sub){
        if(ind == arr.length){
            System.out.println(sub);
            return;
        }

        // Take element
        sub.add(arr[ind]);
        printSubsequence(ind+1, arr, sub);
        sub.remove(sub.size()-1);

        // Don't take element
        printSubsequence(ind+1, arr, sub);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        printSubsequence(0, arr, new ArrayList<>());
    }
}
