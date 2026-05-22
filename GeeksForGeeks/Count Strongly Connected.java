class Solution {
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
        }
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFS(i, adj, st, visited);
            }
        }
        
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            revadj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            revadj.get(s).add(f);
        }
        
        Arrays.fill(visited, false);
        Stack<Integer> stnew = new Stack<>();
        int count = 0;
        while(!st.isEmpty()){
            int top = st.pop();
            if(visited[top] == false){
                DFS(top, revadj, stnew, visited);
                count++;
            }
        }
        return count;
        
    }
    
    public void DFS(int start, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited){
        visited[start] = true;
        for(int n: adj.get(start)){
            if(visited[n]==false){
                DFS(n, adj, st, visited);
            }
        }
        st.push(start);
    }
}