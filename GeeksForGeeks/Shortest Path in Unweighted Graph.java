class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i  =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i  =0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        if(src==dest){return 0;}
        q.add(src);
        visited[src]=true;
        
        int count = 1;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i = 0; i<size; i++){
                int curr = q.poll();
                for(int x: adj.get(curr)){
                    if(visited[x]==false){
                        if(x==dest){
                            return count;
                        }
                        visited[x]=true;
                        q.add(x);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}