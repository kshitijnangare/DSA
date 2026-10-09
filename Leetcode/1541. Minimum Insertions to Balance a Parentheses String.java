class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        boolean doubleclose = false;

        int n = s.length();
        int i =0;
        while(i<n){
            char c = s.charAt(i);

            if(c==')'){
                // double ))
                if(i+1<n && s.charAt(i+1)==')'){
                    if(!st.isEmpty()){
                        st.pop();
                    }else{
                        ans++;
                    }
                    i=i+2;
                }
                // single )
                else{
                    if(!st.isEmpty()){
                        st.pop();
                        ans++;
                    }else{
                        ans+=2;
                    }
                    i++;
                }
            }else{
                st.push('(');
                i++;
            }
        }

        ans += st.size() * 2;
        return ans;
    }
}