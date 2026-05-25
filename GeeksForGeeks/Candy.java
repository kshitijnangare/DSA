class Solution {
    public int minCandy(int arr[]) {
        // code here
        /** Method 1: Storing 2 Values in A Single Array Slot arr[i] 
        But it is not useful here because the constraints are more
        0 ≤ arr[i] ≤ 109
        the array is of type int and not long. multiplcation goes out of
        int limit
        */

        // int n = arr.length;
        // int m = 20001;
        // int x = arr[0] + (1*m);
        // arr[0] = x;
        // for(int i = 1; i<n; i++){
        //     x = arr[i-1];
        //     int a = x%m;
        //     int b = x/m;
        //     if(a<arr[i]){
        //         b++;
        //     }else{
        //         b=1;
        //     }
        //     arr[i] = arr[i] + (b*m);
        // }
        // int total = 0;
        // int leftCandies = arr[n-1]/m;
        // int rightCandies = 1;
        // total+= Math.max(rightCandies, leftCandies);

        // for(int i = n-2; i>=0; i-- ){
        //     x= arr[i+1];
        //     int nexta = x%m;
        //     int curra = arr[i]%m;
        //     leftCandies = arr[i]/m;

        //     if(curra>nexta){
        //         rightCandies++;
        //     }else{
        //         rightCandies=1;
        //     }
        //     total+= Math.max(rightCandies, leftCandies );
        // }
        // return total;

        /** Method 2: Slope technique */

        int n = arr.length;
        if(n==1){return 1;}
        int total = 1;
        int i = 1;
        while (i < n) {
            if (arr[i] == arr[i - 1]) {
                total += 1;
                i++;
                continue;
            }
            int upCount = 0;
            while (i < n && arr[i] > arr[i - 1]) {
                upCount++;
                total += (upCount + 1);
                i++;
            }
            int downCount = 0;
            while (i < n && arr[i] < arr[i - 1]) {
                downCount++;
                total += downCount;
                i++;
            }
            if (upCount > 0 || downCount > 0) {
                total -= (upCount + 1);
                total += Math.max(upCount, downCount) + 1;
            }
        }

        return total;
    }
}
