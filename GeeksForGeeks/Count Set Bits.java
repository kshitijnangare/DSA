class Solution {
    public int setBits(int n) {
        // code here
        int ans = 0;
        while(n>0){
            n=n & (n-1);
            ans++;
        }
        return ans;
    }
}