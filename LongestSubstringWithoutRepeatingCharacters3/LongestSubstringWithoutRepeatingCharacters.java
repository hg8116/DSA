// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> hs = new HashSet<>();

        while(b_pointer < s.length()){
            if(!hs.contains(s.charAt(b_pointer))){
                hs.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hs.size(), max);
            }
            else{
                hs.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }

        return max;
    }
}
