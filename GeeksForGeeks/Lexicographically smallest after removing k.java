class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
        int n = s.length();
        if((n & (n-1)) == 0){
            k=k/2;
        }else{
            k=k*2;
        }
        
        if(k>=n){
            return "-1";
        }
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            while(k>0 && !st.isEmpty() && st.peek()>c){
                k--;
                st.pop();
            }
            st.push(c);
        }
        
        if(k>0){
            while(k-->0){
                st.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}