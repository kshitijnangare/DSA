class Solution {
    public static int maxDepth(String s) {
        // code here
        int maxi = 0;
        int curr = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                curr++;
                maxi=Math.max(maxi, curr);
            }else if(c==')'){
                curr--;
            }
        }
        return maxi;
    }
}
