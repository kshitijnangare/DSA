class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // use min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: nums){
            pq.add(x);
        }
        int max = nums[0];
        int min = Integer.MAX_VALUE;
        for(int i =0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            min = pq.peek();
            if(max-min<=k){
                return i;
            }
            pq.remove(nums[i]);
        }
        return -1;
    }
}

// 5 0 1 4 
// k = 3
// i = 0 => 5-0=5
// i = 1 => 5-0=5
// i = 2 => 5-1=4
// i = 3 => 5-4=1


// 1 2 2 2 2
