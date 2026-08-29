class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int maxScore = countValidSplits(nums);        
        for(int k=0; k<n; k++) {
            if(n-1<2) continue;             
            int[] arr = new int[n-1];
            int idx=0;
            for(int j = 0; j<n; j++) {
                if(j!= k){
                    arr[idx++] = nums[j];
                }
            }
            maxScore = Math.max(maxScore, countValidSplits(arr));
        }
        return maxScore;
    }
    
    int countValidSplits(int[] arr) {
        int m = arr.length;
        if(m < 2)return 0;
        
        int[] pref = new int[m];
        int[] suff = new int[m];
        
        pref[0] = arr[0];
        for(int i=1; i<m; i++) {
            pref[i] = gcd(pref[i-1], arr[i]);
        }
        suff[m-1] = arr[m-1];
        for(int i = m-2; i>=0; i--) {
            suff[i] = gcd(suff[i+1], arr[i]);
        }
        
        int validSplits = 0;
        for(int i=0; i<m-1; i++) {
            if(pref[i]== suff[i+1]) {
                validSplits++;
            }
        }
        return validSplits;
    }
    
    int gcd(int a, int b) {
        while(b!=0) {
            int temp = b;
            b=a % b;
            a=temp;
        }
        return a;
    }
}