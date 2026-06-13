class Solution {
    private final int MOD = 1000000007;

    public int computeValue(int n) {
        int maxLimit = 2 * n;
        long[] fact = new long[maxLimit + 1];
        
  
        fact[0] = 1;
        for(int i = 1; i <= maxLimit; i++){
            fact[i] = (fact[i-1] * i) % MOD;
        }
        long numerator = fact[2*n];
        long denominator = (fact[n] * fact[n]) % MOD;
        
        long invDenominator = power(denominator, MOD - 2);
        
        long ans = (numerator * invDenominator) % MOD;
        return (int) ans;
    }
    
    private long power(long base, long exp) {
        long res = 1;
        base = base % MOD;
        while(exp > 0){
            if((exp & 1) == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}