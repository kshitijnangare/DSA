class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length; 
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i  =0; i<row; i++){
            if(grid[i][0]==1){
                visited[i][0]=true;
                q.add(new int[]{i, 0});
            }
            if(grid[i][col-1]==1){
                visited[i][col-1]=true;
                q.add(new int[]{i,col-1});
            }
        }
        for(int j = 1; j<col-1; j++){
            if(grid[0][j]==1){
                visited[0][j]=true;
                q.add(new int[]{0,j});
            }
            if(grid[row-1][j]==1){
                visited[row-1][j]=true;
                q.add(new int[]{row-1, j});
            }
        }

        int[] rc = {-1,0,1,0};
        int[] cc = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i = 0; i<4; i++){
                int ni = curr[0] + rc[i];
                int nj = curr[1] + cc[i];
                if(ni>=0 && ni<row && nj>=0 && nj<col && visited[ni][nj]==false && grid[ni][nj]==1){
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
}