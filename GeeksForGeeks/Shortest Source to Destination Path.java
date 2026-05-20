// User function Template for Java
class Node{
    int f;
    int s;
    int t;
    Node(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}
class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0));
        visited[0][0] = true;
        if(A[0][0]==0){
            return -1;
        }
        
        int rc[] = {1,0,-1,0};
        int cc[] = {0,1,0,-1};
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int f = curr.f;
            int s = curr.s;
            int t = curr.t;
            
            if(f==X && s==Y){
                return t;
            }
            for(int i = 0; i<4; i++){
                int nf = f+rc[i];
                int ns = s+cc[i];
                if(nf>=0 && nf<N && ns>=0 && ns<M && visited[nf][ns]==false && A[nf][ns]==1){
                    q.add(new Node(nf,ns,t+1));
                    visited[nf][ns] = true;
                }
            }
            
        }
        return -1;
    }
};