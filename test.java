import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (i <= 0 || j <= 0)
            return 0;
        else if (s1.charAt(i) == s2.charAt(j))
            return 1 + lcs(s1, s2, i - 1, j - 1, dp);
        else
            return Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
    }

    public static void main(String[] args) {
        int[][] dp = new int[26][26];
        String s1 = "bddsddeea";
        String s2 = "abbeddea";
        System.out.println(lcs(s1, s2, s1.length()-1, s2.length()-1, dp));
    }
}