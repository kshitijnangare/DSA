class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int x: nums){
            xor = xor^ x;
        }
        int k = (xor & (~(xor-1)));
        int res1= 0;
        int res2=0;
        for(int x: nums){
            if((x & k)!=0){
                res1=res1^x;
            }else{
                res2=res2^x;
            }
        }
        
        return new int[]{res1, res2};
    }
}