// https://leetcode.com/problems/determine-if-string-halves-are-alike/

package DetermineIfStringHalvesAreAlike1704;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int n = s.length();
        int i = 0;
        int j = n / 2;

        int count = 0;
        while (i < n / 2 && j < n) {
            if (vowels.indexOf(s.charAt(i)) >= 0)
                count++;
            if (vowels.indexOf(s.charAt(j)) >= 0)
                count--;

            i++;
            j++;
        }

        return count == 0;
    }
}
