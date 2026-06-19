class Solution {
    public int largestAltitude(int[] gain) {
        int currAltitude = 0;
        int max = 0;
        for(int x: gain){
            currAltitude = currAltitude + x;
            max = Math.max(currAltitude, max);
        }
        return max;
    }
}