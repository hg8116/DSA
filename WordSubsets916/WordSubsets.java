// https://leetcode.com/problems/word-subsets/

package WordSubsets916;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] target = new int[26];

        for(String word: words2){
            int[] temp = new int[26];
            for(char ch: word.toCharArray()){
                temp[ch - 'a']++;
                target[ch - 'a'] = Math.max(temp[ch - 'a'], target[ch - 'a']);
            }
        }

        for(String word: words1){
            int[] source = new int[26];
            for(char ch: word.toCharArray())
                source[ch - 'a']++;

            if(subset(source, target))
                ans.add(word);
        }

        return ans;
    }

    public boolean subset(int[] source, int[] target){
        for(int i=0; i<26; i++){
            if(source[i] < target[i])
                return false;
        }

        return true;
    }
}
