// Tried to develop something other than brute force
// fails for [31,8] [47,64] [3,7] [95,44]

// class Pair{
//     int f;
//     int s;
//     Pair(int f, int s){
//         this.f = f;
//         this.s = s;
//     }
// }

// class Solution {
//     public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
//         int timer = 0;
//         Pair[] land = new Pair[landStartTime.length];
//         for(int i = 0; i<landStartTime.length; i++){
//             land[i] = new Pair(landStartTime[i], landDuration[i]);
//         }
//         Pair[] water = new Pair[waterStartTime.length];
//         for(int i = 0; i<waterStartTime.length; i++){
//             water[i] = new Pair(waterStartTime[i], waterDuration[i]);
//         }
//         Arrays.sort(land, (a,b)->{
//             int sumA = a.f + a.s;
//             int sumB = b.f + b.s;
//             if(sumA == sumB) {
//                 return Integer.compare(a.s, b.s);
//             }
//             return Integer.compare(sumA, sumB);
//         });

//         Arrays.sort(water, (a,b)->{
//             int sumA = a.f + a.s;
//             int sumB = b.f + b.s;
//             if(sumA == sumB) {
//                 return Integer.compare(a.s, b.s);
//             }
//             return Integer.compare(sumA, sumB);
//         });

//         int landF = land[0].f;
//         int landS = land[0].s;
//         int waterF = water[0].f;
//         int waterS = water[0].s;
//         // just to check the output
//         // System.out.println(landF);
//         // System.out.println(landS);
//         // System.out.println(waterF);
//         // System.out.println(waterS);

//         if(landF<waterF){
//             timer+=landF+landS;
//             if(timer<waterF){
//                 timer=waterF;
//             }
//             timer+=waterS;
//         }else if(landF>waterF){
//             timer+=waterF+waterS;
//             if(timer<landF){
//                 timer = landF;
//             }
//             timer+=landS;
//         }else{
//             timer+=landF+landS+waterS;
//         }
//         return timer;
//     }
// }


// brute force
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        // int n = landDuration.length;
        // int m = waterDuration.length;
        // int globalMin = Integer.MAX_VALUE;
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         int landS = landStartTime[i];
        //         int landD = landDuration[i];
        //         int waterS = waterStartTime[j];
        //         int waterD = waterDuration[j];
        //         int landMin = landS+landD;
        //         if(landMin<waterS){
        //             landMin = waterS;
        //         }
        //         landMin+=waterD;
        //         int waterMin = waterS+waterD;
        //         if(waterMin<landS){
        //             waterMin = landS;
        //         }
        //         waterMin+=landD;
        //         int currMin = Math.min(waterMin, landMin);
        //         globalMin = Math.min(currMin, globalMin);
        //     }
        // }
        // return globalMin;

        // Good apprach of O(n+m) time. Go this from solutions.

        int minL = 3000, minW = minL, res = minW;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i = 0; i < n; i++)
            minL = Math.min(minL, landStartTime[i] + landDuration[i]);

        for(int i = 0; i < m; i++) {
            minW = Math.min(minW, waterStartTime[i] + waterDuration[i]);
            res = Math.min(res, Math.max(minL, waterStartTime[i]) + waterDuration[i]);
        }

        for(int i = 0; i < n; i++)
            res = Math.min(res, Math.max(minW, landStartTime[i]) + landDuration[i]);

        return res;
    }
}
