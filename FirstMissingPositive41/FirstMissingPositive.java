// https://leetcode.com/problems/first-missing-positive/

package FirstMissingPositive41;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length, i = 0;

        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && arr[i] != arr[correct] && arr[i] <= n)
                swap(arr, i, correct);
            else
                i++;
        }

        for (i = 0; i < n; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}