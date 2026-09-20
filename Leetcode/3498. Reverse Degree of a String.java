class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int total = 0;
        for(int i = 0; i<n; i++){
            char c= s.charAt(i);
            int cint = c-'a';
            // cint = cint + 1;
            int multiplier = 26-cint;
            int product = multiplier * (i+1);
            total += product;
        }
        return total;
    }
}