class myQueue {

    // Initialize your data members
    Stack<Integer> st1;
    Stack<Integer> st2;
    public myQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    void enqueue(int x) {
        // Implement enqueue operation
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    void dequeue() {
        // Implement dequeue operation
        if(!st1.isEmpty()){
            st1.pop();
        }
    }

    int front() {
        // Implement front operation
        if(st1.isEmpty()){return -1;}
        return st1.peek();
    }

    int size() {
        // Implement size operation
        return st1.size();
    }
}
