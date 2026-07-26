class SpecialStack {
    private Stack<Long> st;
    private long mini;
    public SpecialStack() {
        // Define Stack
        st = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        long value = x;
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

    public void pop() {
        // Remove the top element from the Stack
        if (st.isEmpty()) return;
        long x = st.pop();
        if (x < mini) {
            mini = 2 * mini - x;
        }
    }

    public int peek() {
        // Returns top element of the Stack
        if (st.isEmpty()) return -1;
        long x = st.peek();
        if (x >= mini) return (int) x;
        return (int) mini;
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return st.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if(st.isEmpty()){return -1;}
        return (int) mini;
    }
}