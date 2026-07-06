class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int high = arr.length-1;
        int low = 0;
        int ans = arr.length;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
