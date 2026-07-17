class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(isConnected[i][j]==1){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        int count = 0;
        for(int i = 0; i<n; i++){
            if(visited[i]==false){
                dfs(list, i, visited);
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