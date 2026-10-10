class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        // for(int i = 0; i<nums1.length; i++){
        //     int diff = Math.abs(nums1[i]-nums2[i]);
        //     pq.add(diff);
        // }
        // int total = k1+k2;
        // while(total!=0 && !pq.isEmpty()){
        //     if(pq.peek()==0){
        //         pq.poll();
        //     }else{
        //         int top = pq.poll();
        //         top--;
        //         pq.add(top);
        //         total--;
        //     }
        // }
        // long ans = 0;
        // while(!pq.isEmpty()){
        //     ans+= Math.pow(pq.poll(), 2);
        // }
        // return ans;


        int n = nums1.length;
        int maxDiff =0;
        int[] count =new int[100005];
        for (int i=0; i<n; i++) {
            int diff = Math.abs(nums1[i]-nums2[i]);
            count[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }
        
        long totalOps = (long) k1+k2;
        for (int i=maxDiff; i>0; i--) {
            if (count[i]>0) {
                if(totalOps>=count[i]) {
                    totalOps-=count[i];
                    count[i-1]+=count[i];
                    count[i]=0;
                } else {
                    count[i]-=totalOps;
                    count[i-1]+=totalOps;
                    totalOps=0;
                    break;
                }
            }
        }

        long ans = 0;
        for (int i=1; i<=maxDiff; i++) {
            if (count[i]>0) {
                ans += (long) count[i] * i * i;
            }
        }
        return ans;
    }
}

// [1,2,3,4]
// [2,10,20,19]
// [1,8,17]