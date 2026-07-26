import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String s) {
        // Write your code here.
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c=='[' || c=='{'){
                st.add(c);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char ct = st.pop();
                if(c==')' && ct!='('){
                    return false;
                }else if(c==']' && ct!='['){
                    return false;
                }else if(c=='}' && ct!='{'){
                    return false;
                }
            }
        }
        return true;

    }
}