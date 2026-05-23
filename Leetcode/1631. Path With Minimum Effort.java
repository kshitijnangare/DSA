class Triplet{
    int i;
    int j;
    int w;
    Triplet(int i, int j, int w){
        this.i = i;
        this.j = j;
        this.w = w;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        ArrayList<ArrayList<ArrayList<Triplet>>> adj = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];

        for(int i = 0; i<row; i++){
            adj.add(new ArrayList<ArrayList<Triplet>>());
            for(int j = 0; j<col; j++){
                adj.get(i).add(new ArrayList<Triplet>());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;

        int[] rc = {1,0};
        int[] cc = {0,1};
        for(int i = 0; i<row; i++ ){
            for(int j = 0; j<col; j++){
                for(int k = 0; k<2; k++){
                    int nr = i+rc[k];
                    int nc = j+cc[k];
                    if(nr>=0 && nr<row && nc>=0 && nc<col){
                        int efforts = Math.abs(heights[i][j] - heights[nr][nc]);
                        adj.get(i).get(j).add(new Triplet(nr, nc, efforts));
                        adj.get(nr).get(nc).add(new Triplet(i, j, efforts));
                    }
                }
            }
        }
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w,b.w));
        pq.add(new Triplet(0,0,dist[0][0]));

        while(!pq.isEmpty()){
            Triplet curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            int w = curr.w;

            for(Triplet t: adj.get(i).get(j)){
                int totalW = Math.max(w, t.w);
                if(totalW<dist[t.i][t.j]){
                    dist[t.i][t.j] = totalW;
                    pq.add(new Triplet(t.i,t.j,totalW));
                }
            }
        }
        return dist[row-1][col-1];

    }
}