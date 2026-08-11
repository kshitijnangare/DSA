class Solution {
    public void fill(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        
        Queue<int[]>  q = new LinkedList<>();
        for(int i = 0; i<row; i++){
            if(grid[i][0]=='O'){
                q.add(new int[]{i,0});
                visited[i][0]=true;
            }
            if(grid[i][col-1]=='O'){
                q.add(new int[]{i,col-1});
                visited[i][col-1]=true;
            }
        }
        for(int j = 1; j<col-1; j++){
            if(grid[0][j]=='O'){
                q.add(new int[]{0, j});
                visited[0][j]=true;
            }
            if(grid[row-1][j]=='O'){
                q.add(new int[]{row-1, j});
                visited[row-1][j]=true;
            }
        }
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            int curri = q.peek()[0];
            int currj = q.peek()[1];
            q.poll();
            
            for(int i = 0; i<4; i++){
                int ni = curri+dx[i];
                int nj = currj+dy[i];
                
                if(ni>=0 && nj>=0 && ni<row && nj<col && !visited[ni][nj] && grid[ni][nj]=='O'){
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        }
        
        for(int i = 1; i<row-1; i++){
            for(int j = 1; j<col-1; j++){
                if(grid[i][j]=='O' && visited[i][j]==false){
                    grid[i][j] = 'X';
                }
            }
        }
    }
}
