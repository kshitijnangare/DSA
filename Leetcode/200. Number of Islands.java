class Solution {
    public int numIslands(char[][] grid) {
        int col = grid[0].length; 
        int row = grid.length;
        boolean[][] visited = new boolean[row][col];
        int count =0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    count++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    void bfs(char[][] grid, int i, int j, boolean[][] visited){
        visited[i][j]= true;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        int[] rc = {-1,0,1,0};
        int[] cc = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int k = 0; k<4; k++ ){
                int ni = curr[0] + rc[k];
                int nj = curr[1] + cc[k];
                if(ni>=0 && ni<row && nj>=0 && nj<col && grid[ni][nj]=='1' && visited[ni][nj]==false){
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        }
    }
}