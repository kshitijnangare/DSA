class Solution {
    public int leastWeightCapacity(ArrayList<Integer> arr, int D) {
        // code here
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int x: arr){
            max = Math.max(max, x);
            sum = sum + x;
        }
        int low = max;
        int high = sum;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(helper(arr, D, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    boolean helper(ArrayList<Integer> w, int d, int capacity){
        int actualDays = 1;
        int sum = 0;
        for(int x: w){
            if(sum+x<=capacity){
                sum += x;
            }else{
                sum = x;
                actualDays++;
            }
        }
        return actualDays<=d;
    }
}