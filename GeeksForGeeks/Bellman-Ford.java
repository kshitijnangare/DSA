// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        int max = (int) Math.pow(10, 8);
        Arrays.fill(dist, max);
        dist[src]=0;
        
        for(int i = 0; i<V-1; i++){
            for(int j = 0; j<edges.length; j++){
                int source = edges[j][0];
                int destination = edges[j][1];
                int wt = edges[j][2];
                
                if(dist[source]!=max && dist[source]+wt<dist[destination]){
                    dist[destination] = dist[source]+wt;
                }
            }
        }
        
        for (int j=0; j<edges.length; j++) {
            int source = edges[j][0];
            int destination = edges[j][1];
            int wt = edges[j][2];
            if (dist[source]!=max && dist[source]+wt<dist[destination]) {
                return new int[]{-1}; 
            }
        }
        
        return dist;
    }
}
