class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
        }
        
        int mother = -1;
        boolean[] visited = new boolean[V];
        for(int i = 0; i<V; i++){
            if(visited[i]==false){
                dfs(i, adj, visited);
                mother = i;
            }
        }
        Arrays.fill(visited, false);
        dfs(mother, adj, visited);
        
        for(boolean x: visited){
            if(x==false){
                return -1;
            }
        }
        return mother;
    }
    
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int it: adj.get(node)){
            if(visited[it]==false){
                dfs(it, adj, visited);
            }
        }
    }
}