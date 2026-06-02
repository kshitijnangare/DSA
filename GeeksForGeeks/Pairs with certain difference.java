class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        int i = n-1;
        while(i>0){
            int f = arr[i];
            int s = arr[i-1];
            if(f-s<k){
                sum+=f+s;
                i=i-2;
            }else{
                i=i-1;
            }
        }
        return sum;
    }
}