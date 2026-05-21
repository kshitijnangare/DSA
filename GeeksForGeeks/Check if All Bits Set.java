class Solution {
    public boolean isBitSet(int n) {
        // code here
        if(n==0){
            return false;
        }
        if(((n+1) & n) == 0){
            return true;
        }else{
            return false;
        }
    }
};