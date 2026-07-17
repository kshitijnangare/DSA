class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        boolean visited[] = new boolean[V+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        
        for(int i =0; i<V; i++){
            if(visited[i]==false){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(adj, i, visited, temp);
                list.add(temp);
            }
        }
        return list;
    }
    void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, ArrayList<Integer> temp){
        visited[s]=true;
        temp.add(s);
        
        for(int x: adj.get(s)){
            if(visited[x]==false){
                dfs(adj, x, visited, temp);
            }
        }
    }
    
}