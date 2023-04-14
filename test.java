
import java.util.*;

public class test {
    static void printLcs(String s1, String s2) {
        int len1 = s1.length() + 1;
        int len2 = s2.length() + 1;

        int[][] dp = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int ind = dp[len1-1][len2-1];
        StringBuilder sub = new StringBuilder();
        int i = len1-1;
        int j = len2-1;
        while (i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sub.insert(0,s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }
        System.out.println(sub);
    }

    public static void main(String[] args) {
        printLcs("abacda", "abdacadba");
    }
}


