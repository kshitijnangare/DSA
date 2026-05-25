class Solution {
    public int candy(int[] ratings) {

        /** Method 1: Storing 2 Values in A Single Array Slot ratings[i] */

        // int n = ratings.length;
        // int m = 20001;
        // int x = ratings[0] + (1*m);
        // ratings[0] = x;
        // for(int i = 1; i<n; i++){
        //     x = ratings[i-1];
        //     int a = x%m;
        //     int b = x/m;
        //     if(a<ratings[i]){
        //         b++;
        //     }else{
        //         b=1;
        //     }
        //     ratings[i] = ratings[i] + (b*m);
        // }
        // int total = 0;
        // int leftCandies = ratings[n-1]/m;
        // int rightCandies = 1;
        // total+= Math.max(rightCandies, leftCandies);

        // for(int i = n-2; i>=0; i-- ){
        //     x= ratings[i+1];
        //     int nexta = x%m;
        //     int curra = ratings[i]%m;
        //     leftCandies = ratings[i]/m;

        //     if(curra>nexta){
        //         rightCandies++;
        //     }else{
        //         rightCandies=1;
        //     }
        //     total+= Math.max(rightCandies, leftCandies );
        // }
        // return total;

        /** Method 2: Slope technique */

        int n = ratings.length;
        if(n==1){return 1;}
        int total = 1;
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                total += 1;
                i++;
                continue;
            }
            int upCount = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                upCount++;
                total += (upCount + 1);
                i++;
            }
            int downCount = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
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