// https://leetcode.com/problems/optimal-partition-of-string/description/

package OptimalPartitionOfString2405;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        int[] count = new int[26];
        int ans = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] >= j) {
                ans++;
                j = i + 1;
            }
            count[s.charAt(i) - 'a'] = i + 1;
        }

        return ans;
    }
}
