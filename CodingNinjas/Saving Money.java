import java.util.*;
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
public class Solution {
    public static int savingMoney(int n, int source, int destination, int k, List<List<Integer>> trains) {
        // Write your code here.
        ArrayList<ArrayList<Triplet>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<trains.size(); i++){
            int f = trains.get(i).get(0);
            int s = trains.get(i).get(1);
            int t = trains.get(i).get(2);
            adj.get(f).add(new Triplet(s,t,0));
        }
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[source]=0;
        int min = INF;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(source,0,0));
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
        return dist[destination]==INF ? -1 : dist[destination];
    }
}