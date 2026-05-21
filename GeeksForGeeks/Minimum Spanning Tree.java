class Triplet{
    int w;
    int n;
    int p;
    Triplet(int w, int n, int p){
        this.w = w;
        this.n = n;
        this.p = p;
    }
}

class Node{
    int n;
    int w;
    Node(int n, int w){
        this.w = w;
        this.n = n;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.w, b.w));
        int maxwt = 0;
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<Node>());
        }
        
        for(int i = 0; i<edges.length; i++){

            int n = edges[i][0];
            int c = edges[i][1];
            int w = edges[i][2];
            
            adj.get(n).add(new Node(c, w));
            adj.get(c).add(new Node(n, w));
        }
        
        pq.add(new Triplet(0,0,-1));
        
        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            int p = t.p;
            int n = t.n;
            int w = t.w;
            if(visited[n] == true){
                continue;
            }
            if(visited[n] == false){
                maxwt = maxwt + w;
                visited[n] = true;
            }
            
            for(Node node: adj.get(n)){
                if(visited[node.n] == false){
                    pq.add(new Triplet(node.w,node.n,n));
                }
            }
        }
        return maxwt;
    }
}