class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int prev = arr[0]^arr[1];
        int n = arr.length;
        for(int i = 1; i<n-1; i++){
            int curr = arr[i-1] ^ arr[i+1];
            arr[i-1]=prev;
            prev=curr;
        }
        arr[n-1]=arr[n-2]^arr[n-1];
        arr[n-2]=prev;
    }
}