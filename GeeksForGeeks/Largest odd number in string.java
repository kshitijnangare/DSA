class Solution {
    public String maxOdd(String s) {
        // code here
        int n = s.length();
        for(int i = n-1; i>=0; i--){
            char c= s.charAt(i);
            int x = c-'0';
            if(x%2==1){
                String s2 = s.substring(0, i+1);
                return s2;
            }
        }
        return "";
    }
}