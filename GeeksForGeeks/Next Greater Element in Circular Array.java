class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int maxind = 0;
        for(int i = 0; i<n; i++){
            if(arr[i]>=max){
                maxind = i;
                max = arr[i];
            }
        }
        int res[] = new int[n];
        res[maxind] = -1;
        Stack<Integer> st = new Stack<>();
        st.add(max);
        for(int i = n-2; i>=0; i--){
            int curind = (maxind+i+1)%n;
            int x = arr[curind];
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
        ArrayList<Integer> reslist = new ArrayList<>();
        for (int num : res) {
            reslist.add(num);
        }
        return reslist;
    }
}