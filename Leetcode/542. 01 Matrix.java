class Triplet{
    int i;
    int j;
    int near;
    Triplet(int i, int j, int near){
        this.i=i;
        this.j=j;
        this.near =near;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] res = new int[row][col];
        for(int []r: res){
            Arrays.fill(r, -1);
        }

        Queue<Triplet> q = new LinkedList<>();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(mat[i][j] == 0){
                    res[i][j]=0;
                    visited[i][j]=true;
                    q.add(new Triplet(i,j,0));
                }
            }
        }

        int[] rc= {-1,0,1,0};
        int[] cc = {0,-1,0,1};
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int steps = t.near;
            for(int i = 0; i<4; i++){
                int ni = t.i+rc[i];
                int nj = t.j + cc[i];
                if(ni>=0 && ni<row && nj>=0 && nj<col && mat[ni][nj]==1 && visited[ni][nj]==false){
                    res[ni][nj]=steps+1;
                    visited[ni][nj]=true;
                    q.add(new Triplet(ni,nj, steps+1));
                }
            }
        }
        return res;

    }
}