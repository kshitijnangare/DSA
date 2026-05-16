class Solution {
    int count = 0;
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
        // Code here
        count = 0;
        dfs(adj, source, destination);
        return count;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj, int current, int destination){
        if (current == destination) {
            count++;
            return;
        }
        for (int neighbor : adj.get(current)) {
            dfs(adj, neighbor, destination);
        }
    }
}