package RemovingStarsFromAString2390;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*')
                ans.deleteCharAt(ans.length() - 1);
            else
                ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
