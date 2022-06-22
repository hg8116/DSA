// https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

package NthRootOfMCS;

public class NthRootOfM {
    public static double findNthRootOfM(int n, long m){
        double start = 1.0;
        double end = m;
        double eps = 1e-7;

        while((end - start) > eps){
            double mid = start + (end - start) / 2.0;
            if(multiply(mid, n) < m){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return start;
    }

    public static double multiply(double number, int n){
        double ans = 1.0;
        for (int i=1; i<=n; i++){
            ans *= number;
        }
        return ans;
    }
}
