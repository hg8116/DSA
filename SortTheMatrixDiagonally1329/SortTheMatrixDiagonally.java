// https://leetcode.com/problems/sort-the-matrix-diagonally/

package SortTheMatrixDiagonally1329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int totalRows = mat.length;
        int totalCols = mat[0].length;

        List<Integer> diaElements;

        for (int r = 0; r < totalRows; r++) {
            int i = r;
            int j = 0;

            diaElements = new ArrayList<>();
            while (i < totalRows && j < totalCols) diaElements.add(mat[i++][j++]);
            Collections.sort(diaElements);

            i = r;
            j = 0;
            int k = 0;

            while (i < totalRows && j < totalCols) mat[i++][j++] = diaElements.get(k++);
        }

        for (int c = 0; c < totalCols; c++) {
            int i = 0;
            int j = c;

            diaElements = new ArrayList<>();
            while (i < totalRows && j < totalCols) diaElements.add(mat[i++][j++]);
            Collections.sort(diaElements);

            i = 0;
            j = c;
            int k = 0;

            while (i < totalRows && j < totalCols) mat[i++][j++] = diaElements.get(k++);
        }

        return mat;
    }
}
