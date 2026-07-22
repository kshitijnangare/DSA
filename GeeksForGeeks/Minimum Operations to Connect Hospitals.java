class Solution {
    public int minConnect(int V, int[][] edges) {
        // code here
        if(edges.length < V-1) return -1;
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        int components = 0;
        for(int i  = 0; i<V; i++){
            if(visited[i]==false){
                dfs(i, visited, adj);
                components++;
            }
        }
        return components-1;
    }
    void dfs(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[s]=true;
        for(int x: adj.get(s)){
            if(visited[x]==false){
                dfs(x, visited, adj);
            }
        }
    }
}
