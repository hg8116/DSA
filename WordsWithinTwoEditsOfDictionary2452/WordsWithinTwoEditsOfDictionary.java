// https://leetcode.com/problems/words-within-two-edits-of-dictionary/

package WordsWithinTwoEditsOfDictionary2452;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String q : queries) {
            for (String d : dictionary) {
                int count = 0;
                for (int i = 0; count <= 2 && i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        count++;
                    }
                }
                if (count <= 2) {
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
}
