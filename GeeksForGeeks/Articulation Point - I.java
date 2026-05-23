class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] TIN = new int[V];
        int[] lowestTime = new int[V];
        boolean[] visited = new boolean[V];
        
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            if(visited[i]==false){
                dfs(i, -1, adj, set, visited, TIN, lowestTime);
            }
        }
        for(int x: set){
            res.add(x);
        }
        if(res.size()==0){
            res.add(-1);
        }
        return res;
    }
    
    int timer = 1;
    
    void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, TreeSet<Integer> set, boolean[] visited, int[] TIN, int[] lowestTime){
        visited[node] = true;
        TIN[node] = timer;
        lowestTime[node] = timer;
        timer++;
        int child = 0;
        for(int i = 0; i<adj.get(node).size(); i++){
            int curr = adj.get(node).get(i);
            if(curr==parent){continue;}
            if(visited[curr] == false){
                dfs(curr, node, adj, set, visited, TIN, lowestTime);
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[curr]);
                
                if(lowestTime[curr]>=TIN[node] && parent!=-1){
                    set.add(node);
                }
                child++;
            }else{
                lowestTime[node] = Math.min(lowestTime[node], TIN[curr]);
            }
        }
        if(child>1 && parent==-1){
            set.add(node);
        }
    }
}