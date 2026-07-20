class Solution {
    public int findDelayTime(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            int t = edges[i][2];
            adj.get(f).add(new int[]{s,t});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[1];
            for(int[] arr: adj.get(curr[0])){
                int x = arr[0];
                int wtx = arr[1];
                int totalW = wt + wtx;
                if(totalW < dist[x]){
                    pq.add(new int[]{x, totalW});
                    dist[x]=totalW;
                }
            }
        }
        
        int max = 0;
        for(int x: dist){
            if(x==Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, x);
        }
        return max;
    }
}