import java.util.*;
public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        // Write your code here.
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n-1]=-1;
        st.add(arr[n-1]);
        for(int i = n-2; i>=0; i--){
            int x = arr[i];
            while(!st.empty() && x>=st.peek()){
                st.pop();
            }
            int nextGr = (st.empty()) ? -1 : st.peek();
            res[i]=nextGr;
            st.push(x);
        }
        return res;
    }
}