// https://leetcode.com/problems/palindrome-partitioning/

package PalindromePartioning131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        findCombinations(0, s, ans, new ArrayList<>());

        return ans;
    }

    public void findCombinations(int ind, String s, List<List<String>> ans, List<String> ds){
        if(ind == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                ds.add(s.substring(ind, i + 1));
                findCombinations(i + 1, s, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
