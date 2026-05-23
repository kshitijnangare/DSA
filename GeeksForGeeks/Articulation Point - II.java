class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        
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
    
    static int timer = 1;
    
    static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, TreeSet<Integer> set, boolean[] visited, int[] TIN, int[] lowestTime){
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