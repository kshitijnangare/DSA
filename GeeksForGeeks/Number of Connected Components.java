class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        boolean visited[] = new boolean[V+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edges.size(); i++){
            int f = edges.get(i).get(0);
            int s = edges.get(i).get(1);
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        int count = 0;
        
        for(int i =0; i<V; i++){
            if(visited[i]==false){
                dfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }
    void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited){
        visited[s]=true;
        
        for(int x: adj.get(s)){
            if(visited[x]==false){
                dfs(adj, x, visited);
            }
        }
    }
}