// https://leetcode.com/problems/rotate-image/

package RotateImage48;

public class RotateImage {
    // To rotate a 2D array by 90 deg, transpose it and invert it.

    void transpose(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    void invert(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - 1 - j];
                arr[i][n - 1 - j] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        invert(matrix);
    }
}
