class Solution {
    public boolean isCyclic(int V, int[][] edges) {
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
        
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<V; i++){
            for(int j: adj.get(i)){
                inDegree[j]++;
            }
        }
        
        for(int i = 0; i<V; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int count = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int it: adj.get(curr)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        
        return count != V;
        
    }
}