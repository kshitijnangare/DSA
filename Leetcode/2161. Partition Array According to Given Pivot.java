class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int x:nums){
            if(x<pivot){
                res.add(x);
            }
        }
        for(int x:nums){
            if(x==pivot){
                res.add(x);
            }
        }
        for(int x:nums){
            if(x>pivot){
                res.add(x);
            }
        }
        int[] resarr = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            resarr[i] = res.get(i);
        }
        
        return resarr;
    }
}