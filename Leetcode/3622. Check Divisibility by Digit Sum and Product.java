class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        long prod = 1;

        int x = n;
        while(x!=0){
            int rem = x%10;
            sum+=rem;
            prod*=rem;
            x=x/10;
        }
        long total = prod+sum;
        if(n%total==0){
            return true;
        }else{
            return false;
        }
    }
}