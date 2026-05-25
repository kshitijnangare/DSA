class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        int count = 0;
        for(int x: arr){
            if(x>=start && x<=end){
                count++;
            }
        }
        return (count)==(end-start+1);
    }
}