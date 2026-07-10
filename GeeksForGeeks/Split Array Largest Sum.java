class Solution {
    public int splitArray(int[] arr, int k) {
        // code here
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int x: arr){
            high = high + x;
            low = Math.max(low, x);
        }
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(helper(arr, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean helper(int[] arr, int k, int mid){
        int count = 1;
        int sum = 0;
        for(int x: arr){
            if(sum+x<=mid){
                sum+=x;
            }else{
                count++;
                sum = x;
            }
        }
        return count<=k;
    }
};