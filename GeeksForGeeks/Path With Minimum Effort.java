class Triplet{
    int i;
    int j;
    int wt;
    Triplet(int f, int s, int t){
        i = f;
        j = s;
        wt = t;
    }
}
class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        int INF = Integer.MAX_VALUE;
        int row = mat.length;
        int col = mat[0].length;
        
        int[][] dist = new int[row][col];
        for(int[] rows: dist){
            Arrays.fill(rows, INF);
        }
        dist[0][0]=0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->Integer.compare(a.wt, b.wt));
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        pq.add(new Triplet(0, 0, 0));
        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            int i = t.i;
            int j = t.j;
            int wt = t.wt;
            if (i == row - 1 && j == col - 1) {
                return wt;
            }
            if (wt > dist[i][j]) {
                continue;
            }
            for(int z= 0; z<4; z++){
                int ni = i + dx[z];
                int nj = j + dy[z];
                if(ni>=0 && ni<row && nj>=0 && nj<col){
                    int absdiff = Math.abs(mat[i][j] - mat[ni][nj]);
                    int newEffort = Math.max(wt, absdiff);
                    if(dist[ni][nj]>newEffort){
                        dist[ni][nj] =newEffort;
                        pq.add(new Triplet(ni,nj, dist[ni][nj]));
                    }
                }
            }
        }
        return dist[row-1][col-1];
    }
}
