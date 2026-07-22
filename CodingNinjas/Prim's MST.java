import java.util.*;
import java.io.*; 

class Triplet {
    int n; 
    int p; 
    int wt;
    Triplet(int f, int parent, int s) {
        n = f;
        this.p = parent;
        wt = s;
    }
}

public class Solution {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
        
        boolean[] visited = new boolean[n + 1]; 
        ArrayList<ArrayList<Triplet>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            int f = g.get(i).get(0);
            int s = g.get(i).get(1);
            int t = g.get(i).get(2);
            
            adj.get(f).add(new Triplet(s, f, t));
            adj.get(s).add(new Triplet(f, s, t));
        }
        
        pq.add(new Triplet(1, -1, 0));
        
        while(!pq.isEmpty()){
            Triplet curr = pq.poll();
            int cn = curr.n;
            int pa = curr.p;
            int wt = curr.wt;
            
            if(visited[cn]){
                continue;
            }
            
            visited[cn] = true;
            
            if(pa != -1){
                res.add(new ArrayList<>(Arrays.asList(pa, cn, wt)));
            }
            
            for(Triplet p : adj.get(cn)){
                if(!visited[p.n]){
                    pq.add(new Triplet(p.n, cn, p.wt));
                }
            }
        }
        
        return res;
    }
}