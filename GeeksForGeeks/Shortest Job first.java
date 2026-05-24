class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        for(int i = 1; i<bt.length; i++){
            bt[i] = bt[i]+bt[i-1];
        }
        int avg = 0;
        for(int i = 0; i<bt.length-1; i++){
            avg = avg+bt[i];
        }
        return avg/bt.length;
    }
}
