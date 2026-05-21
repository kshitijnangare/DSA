class Pair{
    int n;
    int w;
    Pair(int n, int w){
        this.n = n;
        this.w = w;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.w,b.w));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            int t = edges[i][2];
            adj.get(f).add(new Pair(s,t));
            adj.get(s).add(new Pair(f,t));
        }
        
        
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            
            if(curr.w > dist[curr.n]){
                continue;
            }
            
            for(Pair pair: adj.get(curr.n)){
                int totaldist = pair.w + dist[curr.n];
                if(totaldist < dist[pair.n]){
                    pq.add(new Pair(pair.n, totaldist));
                    dist[pair.n] = totaldist;
                }
            }
        }
        return dist;
        
    }
}