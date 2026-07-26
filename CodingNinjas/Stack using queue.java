import java.util.*;
public class Solution{
    static class Stack {
        // Define the data members.
        Queue<Integer> q1;
        Queue<Integer> q2;
        boolean isq1;

        public Stack() {
            // Implement the Constructor.
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            isq1 = true;
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            // Implement the getSize() function.
            if(isq1){
                return q2.size();
            }else{
                return q1.size();
            }

        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            if(isq1){
                return q2.isEmpty();
            }else{
                return q1.isEmpty();
            }
        }

        public void push(int element) {
            // Implement the push(element) function.
            if(isq1){
                q1.add(element);
                while(!q2.isEmpty()){
                    q1.add(q2.poll());
                }
                isq1 = false;
            }else{
                q2.add(element);
                while(!q1.isEmpty()){
                    q2.add(q1.poll());
                }
                isq1=true;
            }
        }

        public int pop() {
            // Implement the pop() function.
            if(isq1){
                if(q2.isEmpty()){return -1;}
                int x = q2.poll();
                return x;
            }else{
                if(q1.isEmpty()){return -1;}
                int x = q1.poll();
                return x;
            }
        }

        public int top() {
            // Implement the top() function.
            if(isq1){
                if(q2.isEmpty()){return -1;}
                return q2.peek();
            }else{
                if(q1.isEmpty()){return -1;}
                return q1.peek();
            }
        }
    }
}