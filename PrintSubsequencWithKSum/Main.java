package PrintSubsequencWithKSum;

import java.util.ArrayList;

public class Main {
    static void printSubWithK(int ind, int[] arr, ArrayList<Integer> sub, int currSum, int k) {
        if (currSum == k) {
            System.out.println(sub);
            return;
        }
        if (ind == arr.length)
            return;

        sub.add(arr[ind]);
        printSubWithK(ind + 1, arr, sub, currSum + arr[ind], k);
        sub.remove(sub.size() - 1);
        printSubWithK(ind + 1, arr, sub, currSum, k);
    }

    static int countSubWithK(int ind, int[] arr, ArrayList<Integer> sub, int currSum, int k) {
        if (currSum == k) {
            System.out.println(sub);
            return 1;
        }
        if (ind == arr.length)
            return 0;

        sub.add(arr[ind]);
        int l = countSubWithK(ind + 1, arr, sub, currSum + arr[ind], k);
        sub.remove(sub.size() - 1);
        int r = countSubWithK(ind + 1, arr, sub, currSum, k);

        return l + r;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(countSubWithK(0, arr, new ArrayList<>(), 0, 2));
    }
}
