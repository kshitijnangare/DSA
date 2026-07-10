class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k){
            return -1;
        }
        long low = 0;
        long high =0;
        for(int x: arr){
            if (x > low) {
                low = x; 
            }
            high = high + x;
        }
        long ans = -1;
        while(low<=high){
            long mid = (low + (high-low)/2);
            if(helper(arr, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int)ans;
    }
    public boolean helper(int[] arr, int k, long mid){
        int count = 1;
        int sum = 0;
        for(int each: arr){
            if(sum+each <=mid){
                sum +=each;
            }else{
                sum = each;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return count<=k;
    }
}