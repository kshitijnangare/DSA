class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        // HashSet<Integer> set = new HashSet<Integer>();
        // for(int x: nums1){
        //     set.add(x);
        // }

        // for(int x: nums2){
        //     if(set.contains(x)){
        //         return x;
        //     }
        // }
        // return -1;

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0, j = 0;
        while(i<n1 && j<n2){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return -1;
    }
}