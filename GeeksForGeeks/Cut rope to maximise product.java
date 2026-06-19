class Solution {
    public int maxProduct(int n) {
        // code here
        if (n == 2 || n == 3) {
            return n - 1;
        }
        
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        return product * n;
    }
}