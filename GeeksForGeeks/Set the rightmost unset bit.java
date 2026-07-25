class Solution {
    public int setBit(int n) {
        // code here
        n = n | (n+1);
        return n;
    }
}