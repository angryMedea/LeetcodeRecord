package Hot100;

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (Character c : chars) {
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(!stack.empty()){
                    if (c == ')'){
                        if (stack.pop() != '('){
                            return false;
                        }
                    }
                    if (c == ']'){
                        if (stack.pop() != '['){
                            return false;
                        }
                    }
                    if (c == '}'){
                        if (stack.pop() != '{'){
                            return false;
                        }
                    }
                }else{
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
