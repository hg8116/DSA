// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/

package GreatestCommonDivisorOfStrings1071;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";

        int end = findGcd(str1.length(), str2.length());
        return str1.substring(0, end);
    }

    int findGcd(int a, int b) {
        if (b == 0)
            return a;
        return findGcd(b, a % b);
    }
}
