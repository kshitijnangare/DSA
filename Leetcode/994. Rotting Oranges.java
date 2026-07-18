class Pair{
    int f;
    int s;
    Pair(int f, int s){
        this.f =f;
        this.s=s;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Pair> q = new LinkedList<>();
        int[] rc = {-1,0,1,0};
        int[] cc = {0,-1,0,1};
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                int x =grid[i][j];
                if(x==2){
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int min = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k<size; k++){
                Pair p = q.poll();
                int i = p.f;
                int j = p.s;

                for(int z= 0; z<4; z++){
                    int ni = i + rc[z];
                    int nj = j + cc[z];
                    if(ni>=0 && nj>=0 && ni<row && nj <col && visited[ni][nj]==false && grid[ni][nj]==1 ){
                        visited[ni][nj]=true;
                        grid[ni][nj] = 2;
                        q.add(new Pair(ni,nj));
                    }
                }
            }
            if(!q.isEmpty()){
                min++;
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return min;
    }
}