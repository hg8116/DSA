// https://leetcode.com/problems/find-the-duplicate-number/

package FindTheDuplicateNumber287;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] arr) {
        int n = arr.length, i = 0;

        while (i < n) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct])
                    swap(arr, i, correct);
                else
                    return arr[i];
            } else
                i++;
        }

        return -1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}