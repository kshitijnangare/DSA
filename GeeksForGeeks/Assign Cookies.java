class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // code here
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int i = 0; int j = 0;
        while(i<greed.length && j<cookie.length){
            if(cookie[j]>=greed[i]){
                j++;
                i++;
            }else{
                j++;
            }
        }
        return i;
        
    }
}