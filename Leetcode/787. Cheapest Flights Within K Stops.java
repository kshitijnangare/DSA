class Triplet{
    int node;
    int wt;
    int stop;
    Triplet(int f, int s, int t){
        node = f;
        wt = s;
        stop = t;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Triplet>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length; i++){
            int f = flights[i][0];
            int s = flights[i][1];
            int t = flights[i][2];
            adj.get(f).add(new Triplet(s,t,0));
        }
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src]=0;
        int min = INF;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(src,0,0));
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int node = t.node;
            int wt = t.wt;
            int s = t.stop;

            if(s > k){
                continue;
            }
            for(Triplet x: adj.get(node)){
                int nodex = x.node;
                int wtx = x.wt;

                int newWt = wt + wtx;
                if(dist[nodex] > newWt){
                    dist[nodex] = newWt;
                    q.add(new Triplet(nodex, dist[nodex], s+1));
                }
                
            }
        }
        return dist[dst]==INF ? -1 : dist[dst];
    }
}