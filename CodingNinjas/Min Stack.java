import java.util.* ;
import java.io.*; 

public class Solution {
    private static Stack<Long> st;
    private static long mini;

    static class MinStack {

        // Constructor
        MinStack() {
            // Write your code here.
            st = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            long value = num;
            if (st.isEmpty()) {
                mini = value;
                st.push(value);
                return;
            }
            if (value >= mini) {
                st.push(value);
            } else {
                st.push(2 * value - mini);
                mini = value;
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            // Write your code here.
            if (st.isEmpty()) return -1;
            long x = st.pop();
            if (x < mini) {
                int res = (int) mini;
                mini = 2 * mini - x;
                return res;
            }
            return (int)x;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
            if (st.isEmpty()) return -1;
            long x = st.peek();
            if (x >= mini) return (int) x;
            return (int) mini;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            // Write your code here.
            if(st.isEmpty()){return -1;}
            return (int) mini;
        }
    }
}