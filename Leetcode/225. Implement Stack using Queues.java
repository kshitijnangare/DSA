class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    boolean isq1;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        isq1 = true;
    }
    
    public void push(int x) {
        if(isq1){
            q1.add(x);
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
            isq1 = false;
        }else{
            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            isq1=true;
        }
    }
    
    public int pop() {
        if(isq1){
            int x = q2.poll();
            return x;
        }else{
            int x = q1.poll();
            return x;
        }
    }
    
    public int top() {
        if(isq1){
            return q2.peek();
        }else{
            return q1.peek();
        }
    }
    
    public boolean empty() {
        if(isq1){
            return q2.isEmpty();
        }else{
            return q1.isEmpty();
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */