import java.util.Arrays;

class test {
    public static int[][] diagonalSort(int[][] mat) {
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
//        System.out.println(diagonalSort(mat));
//        int[][] mat = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        int n = mat.length;
        int m = mat[0].length;
        int i = 0, j = 0, x = 0, y = 0, a = 0;
        while (a < n) {
            for (i = 0, j = a; i < n && j < m; i++, j++) {
                System.out.println("i " + i + " j " + j);
                for (x = i + 1, y = j + 1; x < n && y < m; x++, y++) {
                    if (mat[i][j] > mat[x][y]) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[x][y];
                        mat[x][y] = temp;
                    }
                    System.out.println("x " + x + " y " + y);
                }
            }
            for (int[] ar : mat) {
                System.out.println(Arrays.toString(ar));
            }
            System.out.println();
            a++;
            System.out.println(a);
        }

        a = 1;
        while (a < m) {
            for (i = a, j = 0; i < n && j < m; i++, j++) {
                System.out.println("i " + i + " j " + j);
                for (x = i + 1, y = j + 1; x < n && y < m; x++, y++) {
                    if (mat[i][j] > mat[x][y]) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[x][y];
                        mat[x][y] = temp;
                    }
                    System.out.println("x " + x + " y " + y);
                }
            }
            for (int[] ar : mat) {
                System.out.println(Arrays.toString(ar));
            }
            System.out.println();
            a++;
            System.out.println(a);
        }


        for (int[] ar : mat) {
            System.out.println(Arrays.toString(ar));
        }
    }
}