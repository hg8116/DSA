// https://leetcode.com/problems/delete-columns-to-make-sorted/

package DeleteColumnsToMakeSorted944;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int wordLen = strs[0].length();
        int n = strs.length;
        int count = 0;
        for (int i = 0; i < wordLen; i++) {
            char last = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                char curr = strs[j].charAt(i);
                if (curr < last) {
                    count++;
                    break;
                }
                last = curr;
            }
        }
        return count;
    }
}
