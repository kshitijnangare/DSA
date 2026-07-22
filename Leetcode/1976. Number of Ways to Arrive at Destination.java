class Pair{
    int n;
    long w;
    Pair(int f, long s){
        n=f;
        w=s;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int noofways = 1;
        int MOD = 1_000_000_007;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<roads.length; i++){
            int f = roads[i][0];
            int s = roads[i][1];
            long t = roads[i][2];
            adj.get(f).add(new Pair(s,t));
            adj.get(s).add(new Pair(f,t)); 
        }

        int INF = Integer.MAX_VALUE;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        int[] ways = new int[n];
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Long.compare(a.w,b.w));
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            long sofardist = curr.w;
            if (sofardist > dist[curr.n]) continue;
            for(Pair p: adj.get(curr.n)){
                long currdist = p.w;
                int currn = p.n;
                long totalD = sofardist + currdist;
                if( dist[currn]>totalD ){
                    dist[currn]=totalD;
                    ways[currn]=ways[curr.n];
                    pq.add(new Pair(currn, totalD));
                }else if(dist[currn]==totalD){
                    ways[currn] = (ways[curr.n] + ways[currn])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}