class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        list.add(-1);
        st.push(arr[n-1]);
        
        for(int i = n-2; i>=0; i--){
            while(!st.empty() && arr[i]>=st.peek()){
                st.pop();
            }
            int nextGr = (st.empty()) ? -1 : st.peek();
            list.add(nextGr);
            st.push(arr[i]);
        }
        
        Collections.reverse(list);
        return list;
    }
}