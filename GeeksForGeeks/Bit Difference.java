class Solution {
    public static int countBitsFlip(int a, int b) {
        // code here
        int xor = a ^ b;
        int ans = 0;
        while(xor>0){
            xor = xor & (xor-1);
            ans++;
        }
        return ans;
    }
}
