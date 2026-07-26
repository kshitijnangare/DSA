import java.util.*;
public class Solution {
    public static int[] nextGreaterElementII(int []a) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        int n = a.length;
        int maxind = 0;
        for(int i = 0; i<n; i++){
            if(a[i]>=max){
                maxind = i;
                max = a[i];
            }
        }
        int res[] = new int[n];
        res[maxind] = -1;
        Stack<Integer> st = new Stack<>();
        st.add(max);
        for(int i = n-2; i>=0; i--){
            int curind = (maxind+i+1)%n;
            int x = a[curind];
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
