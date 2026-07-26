class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){st.push(c);}
            else{
                if(st.isEmpty()){return false;}
                char stc = st.peek();
                if((stc == '(' && c != ')') || (stc == '[' && c != ']') || (stc == '{' && c != '}')){
                    return false;
                }
                st.pop();
            }
            i++;
        }
        return st.isEmpty();
    }
}