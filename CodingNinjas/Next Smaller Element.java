import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        st.push(arr.get(n-1));
        for(int i = n-2; i>=0; i--){
            int x = arr.get(i);
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