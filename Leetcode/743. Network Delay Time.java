class Pair{
    int n;
    int w;
    Pair(int n, int w){
        this.n = n;
        this.w = w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0; i<times.length; i++){
            int f = times[i][0];
            int s = times[i][1];
            int t = times[i][2];
            adj.get(f).add(new Pair(s,t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.w,b.w));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int w = curr.w;
            for(Pair p: adj.get(curr.n)){
                int totalW = w+p.w;
                if(totalW < dist[p.n]){
                    dist[p.n] = totalW;
                    pq.add(new Pair(p.n, totalW));
                }

            }
        }

        int max=0;
        for(int i = 1; i<n+1; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(dist[i], max);
        }
        return max;
    }
}