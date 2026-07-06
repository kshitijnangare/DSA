class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        int prevF = intervals[0][0];
        int prevS = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            int currF = intervals[i][0];
            int currS = intervals[i][1];
            // int prevF = intervals[i-1][0];
            // int prevS = intervals[i-1][1];
            if(prevF<=currF && currS<=prevS){
                count++;
            }else{
                prevF = currF;
                prevS = currS;
            }
        }
        return intervals.length-count;
    }
}