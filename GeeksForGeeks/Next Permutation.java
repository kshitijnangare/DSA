class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int breakInd = n;
        for(int i = n-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                breakInd=i;
                break;
            }
        }
        
        if(breakInd==n){
            Arrays.sort(arr);
            return;
        }
        
        int immediateGreater = Integer.MAX_VALUE;
        int swapInd = -1;
        for(int i = breakInd+1; i<n; i++){
            if(arr[i]>arr[breakInd]){
                if(immediateGreater>arr[i]){
                    immediateGreater = arr[i];
                    swapInd = i;
                }
            }
        }
        
        if(swapInd==-1){return;}
        int t = arr[swapInd];
        arr[swapInd] = arr[breakInd];
        arr[breakInd]=t;
        
        Arrays.sort(arr,breakInd+1, n);
        return;
        
    }
}