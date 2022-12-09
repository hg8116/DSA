// https://leetcode.com/problems/circular-sentence/

package CircularSentence2490;

public class CircularSentence {
    public boolean isCircularSentence(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(s.charAt(i-1)!=s.charAt(i+1)){
                    return false;
                }
            }
        }
        return s.charAt(0) == s.charAt(s.length()-1);
    }
}
