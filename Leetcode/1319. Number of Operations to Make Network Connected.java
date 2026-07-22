class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length <n-1) return -1;
        boolean visited[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<connections.length; i++){
            int f = connections[i][0];
            int s = connections[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        int components = 0;
        for(int i  = 0; i<n; i++){
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