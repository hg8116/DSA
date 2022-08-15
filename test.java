import java.util.Stack;

class test {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if((s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == ')' && stack.peek() == '('))
                stack.pop();
            System.out.println(stack);
        }

        if(stack.size() != 0) return false;
        return true;
    }
}