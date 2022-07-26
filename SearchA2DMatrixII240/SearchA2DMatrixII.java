// https://leetcode.com/problems/search-a-2d-matrix-ii/

package SearchA2DMatrixII240;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] arr, int target) {
        int row = 0;
        int col = arr[0].length - 1;

        while(row < arr.length && col >= 0){
            if(arr[row][col] == target) return true;
            else if(arr[row][col] > target) col--;
            else row++;
        }

        return false;
    }
}
