class Solution {
    public int findMaxProduct(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        long MOD = 1000000007;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for(int x : arr){
            maxElement = Math.max(maxElement, x);
            if (x > 0) {
                positiveCount++;
            } else if (x < 0) {
                negativeCount++;
                maxNegative = Math.max(maxNegative, x);
            } else {
                zeroCount++;
            }
        }

        if(positiveCount == 0 && negativeCount <= 1){
            return maxElement;
        }

        long product = 1;
        boolean skippedMaxNegative = false;

        for(int x : arr){
            if(x == 0){
                continue;
            }
            if(x < 0){
                if (negativeCount % 2 != 0 && x == maxNegative && !skippedMaxNegative) {
                    skippedMaxNegative = true;
                    continue;
                }
            }
            product = (product * x) % MOD;
        }

        if(product<0){
            product = (product + MOD) % MOD;
        }

        return (int) product;
    }
}