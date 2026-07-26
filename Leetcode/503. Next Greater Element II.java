class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int maxind = 0;
        for(int i = 0; i<n; i++){
            if(nums[i]>=max){
                maxind = i;
                max = nums[i];
            }
        }
        int res[] = new int[n];
        res[maxind] = -1;
        Stack<Integer> st = new Stack<>();
        st.add(max);
        for(int i = n-2; i>=0; i--){
            int curind = (maxind+i+1)%n;
            int x = nums[curind];
            while(!st.isEmpty() && st.peek() <= x){
                st.pop();
            }
            if(st.isEmpty()){
                res[curind] = -1;
            }else{
                res[curind] = st.peek();
            }
            st.add(x);
        }
        return res;
    }
}