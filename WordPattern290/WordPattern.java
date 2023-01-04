package WordPattern290;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;

        Map<Character, String> assign = new HashMap<>();
        Map<String, Boolean> hasAppeared = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (!assign.containsKey(ch)) {
                if (hasAppeared.containsKey(words[i]))
                    return false;
                else {
                    assign.put(ch, words[i]);
                    hasAppeared.put(words[i], true);
                }
            } else {
                String curr = assign.get(ch);
                if (!curr.equals(words[i]))
                    return false;
            }
        }
        return true;
    }
}
