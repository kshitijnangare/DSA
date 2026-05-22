class Pair{
    int n;
    double w;
    Pair(int n, double w){
        this.n = n;
        this.w = w;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            double t = succProb[i];

            adj.get(f).add(new Pair(s,t));
            adj.get(s).add(new Pair(f,t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.w,a.w));
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;
        pq.add(new Pair(start_node, 1.0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.n;
            double w = curr.w;
            for(Pair p: adj.get(node)){
                double totalW = w*p.w;
                if(totalW>dist[p.n]){
                    pq.add(new Pair(p.n, totalW));
                    dist[p.n] = totalW;
                }
            }
        }
        return dist[end_node];       
    }
}