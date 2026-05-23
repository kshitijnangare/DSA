class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(List<Integer> it: connections){
            int f = it.get(0);
            int s = it.get(1);
            adj.get(f).add(s);
            adj.get(s).add(f);
        }

        int[] TIN = new int[n];
        int[] lowestTime = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, bridges, visited, TIN, lowestTime);
        return bridges;

    }
    int timer=1;
    void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> bridges, boolean[] visited, int[] TIN, int[] lowestTime){
        visited[node] = true;
        TIN[node] = timer;
        lowestTime[node] = timer;
        timer++;
        for(int i = 0; i<adj.get(node).size(); i++){
            int curr = adj.get(node).get(i);
            if(curr == parent){continue;}
            if(visited[curr]==false){
                dfs(curr, node, adj, bridges, visited, TIN, lowestTime);
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[curr]);
                if(lowestTime[curr]>TIN[node]){
                    bridges.add(Arrays.asList(curr,node));
                }
            }else{
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[curr]);
            }
        }
    }
}