class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<E; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            int t = edges[i][2];
            adj.get(f).add(new int[]{s,t});
        }
        
        Stack<Integer> st = new Stack<>();
        topoSort(adj, V, st);
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        while(!st.isEmpty()){
            int curr = st.pop();
            int currwt = dist[curr];
            if(currwt!=Integer.MAX_VALUE){
                for(int[] x: adj.get(curr)){
                    int node = x[0];
                    int wt = x[1];
                    
                    if(dist[node] > wt+currwt){
                        dist[node]=wt+currwt;
                    }
                }
            }
        }
        
        for(int i = 0; i<V; i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
        
    }
    void topoSort(ArrayList<ArrayList<int[]>> adj, int V, Stack<Integer> st){
        boolean[] visited = new boolean[V];
        for(int i = 0; i<V; i++){
            if(visited[i]==false){
                dfs(i, visited, adj, st);
            }
        }
    }
    void dfs(int s, boolean[] visited, ArrayList<ArrayList<int[]>> adj, Stack<Integer> st){
        visited[s]=true;
        for(int x[]: adj.get(s)){
            if(visited[x[0]]==false){
                dfs(x[0], visited, adj, st);
            }
        }
        st.push(s);
    }
}