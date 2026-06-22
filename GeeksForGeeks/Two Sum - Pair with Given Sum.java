class Solution {
    // two approaches
    // 1. hashing
    boolean twoSum(int arr[], int target) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int x: arr){
            if(set.contains(target-x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }
}