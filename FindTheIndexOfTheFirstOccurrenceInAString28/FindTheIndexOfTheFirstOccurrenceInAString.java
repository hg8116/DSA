// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

package FindTheIndexOfTheFirstOccurrenceInAString28;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length())
                break;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
