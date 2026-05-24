class Solution {
    public int coin(int[] arr) {
        // code here
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}