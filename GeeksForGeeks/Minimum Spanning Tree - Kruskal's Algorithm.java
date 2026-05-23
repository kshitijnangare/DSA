// User function Template for Java
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _s, int _d, int _w) {
        this.src = _s;
        this.dest = _d;
        this.weight = _w;
    }
    
    @Override
    public int compareTo(Edge compareEdge) {
        return Integer.compare(this.weight, compareEdge.weight);
    }
}

class DisjointSet {
    int[] parent;
    int[] size;
    
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUPar(parent[node]);
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
class Solution {
    static int kruskalsMST(int V, int[][] edgesList) {
        // code here
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < edgesList.length; i++) {
            int u = edgesList[i][0];
            int v = edgesList[i][1];
            int wt = edgesList[i][2];
            edges.add(new Edge(u, v, wt));
        }
        
        Collections.sort(edges);
        
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;
        
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt; 
                ds.unionBySize(u, v);
            }
        }
        
        return mstWt;
    }
}
