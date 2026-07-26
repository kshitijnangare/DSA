class Solution {
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.empty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else if(c=='^' || c=='*' || c=='/' || c=='+' || c=='-' ){
                while(!st.empty() && (
                        (c == '^' && precedence(c) < precedence(st.peek())) ||
                        (c != '^' && precedence(c) <= precedence(st.peek()))
                    ) 
                ){
                    sb.append(st.pop());
                }
                st.push(c);
            }
            else{
                sb.append(c);
            }
        }
        
        while(!st.empty()){
            sb.append(st.pop());
        }
        
        return sb.toString();
        
    }
    
    public static int precedence(char c){
        if(c == '^') return 3;
        else if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return -1;
    }
}