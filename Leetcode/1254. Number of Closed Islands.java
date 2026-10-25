class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(row==1 || col==1){
            return 0;
        }

        boolean[][] visited = new boolean[row][col];

        for(int i =0; i<row; i=i+row-1){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==0 && visited[i][j]==false){
                    BFS(i,j,grid, visited);
                }
            }
        }

        for(int i =0; i<row; i++){
            for(int j = 0; j<col; j=j+col-1){
                if(grid[i][j]==0 && visited[i][j]==false){
                    BFS(i,j,grid, visited);
                }
            }
        }

        int count = 0;
        for(int i = 1; i<row-1; i++){
            for(int j = 1; j<col-1; j++){
                if(grid[i][j]==0 && visited[i][j]==false){
                    count++;
                    BFS(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void BFS(int i, int j, int[][] grid, boolean[][] visited){
        visited[i][j]=true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int ci= curr[0];
            int cj= curr[1];

            for(int k=0; k<4; k++){
                int ni = ci+dx[k];
                int nj= cj+dy[k];

                if(ni>=0 && ni<row && nj>=0 && nj<col && grid[ni][nj]==0 && visited[ni][nj]==false){
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        } 
    }
}