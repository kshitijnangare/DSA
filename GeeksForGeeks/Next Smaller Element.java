class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        st.push(arr[n-1]);
        for(int i = n-2; i>=0; i--){
            int x = arr[i];
            while(!st.isEmpty() && st.peek() >= x){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(-1);
            }else{
                res.add(st.peek());
            }
            st.push(x);
        }
        Collections.reverse(res);
        return res;
    }
}