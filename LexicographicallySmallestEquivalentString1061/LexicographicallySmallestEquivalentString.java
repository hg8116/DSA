// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

package LexicographicallySmallestEquivalentString1061;

public class LexicographicallySmallestEquivalentString {
    int[] par;

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        par = new int[26];
        for (int i = 0; i < 26; i++)
            par[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            int parA = find(a);
            int parB = find(b);

            if (parA < parB)
                par[parB] = parA;
            else
                par[parA] = parB;
        }

        StringBuilder ans = new StringBuilder();
        for (char x : baseStr.toCharArray()) {
            x = (char) (find(x - 'a') + 'a');
            ans.append(x);
        }

        return ans.toString();
    }

    int find(int x) {
        if (par[x] != x)
            par[x] = find(par[x]);

        return par[x];
    }
}
