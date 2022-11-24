package MatrixChainMultiplication;

public class MCM {
    static int mcm(int[] p, int n) {
        int m[][] = new int[n][n];
//        n = n + 1;
//        for (int i = 0; i < n; i++) {
//            m[i][0] = 0;
//            m[0][i] = 0;
//            m[i][i] = 0;
//        }
        int j, cost;
        for (int d = 1; d < n - 1; d++) {
            for (int i = 1; i < n - d; i++) {
                j = i + d;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j-1; k++) {
                    cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        return m[1][n - 1];

    }

    public static void main(String[] args) {
        int arr[] = new int[]{5, 4, 2, 3, 3};
        int size = arr.length;
        System.out.println("size " + size);

        System.out.println(
                "Minimum number of multiplications is "
                        + mcm(arr, size));
    }
}