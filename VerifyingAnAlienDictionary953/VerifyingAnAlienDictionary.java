// https://leetcode.com/problems/verifying-an-alien-dictionary/description/

package VerifyingAnAlienDictionary953;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++)
            orderMap[order.charAt(i) - 'a'] = i;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length())
                    return false;
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currWord = words[i].charAt(j) - 'a';
                    int nextWord = words[i + 1].charAt(j) - 'a';
                    if (orderMap[currWord] > orderMap[nextWord])
                        return false;
                    else
                        break;
                }
            }
        }
        return true;
    }
}
