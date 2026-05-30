class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length;
        int actualSum = 1;
        int sum = 0;
        for(int i = 0; i<n; i++){
            actualSum = actualSum+ i + 2;
            sum = sum+arr[i];
        }
        return actualSum-sum;
    }
}