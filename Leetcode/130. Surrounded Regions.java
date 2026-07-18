class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<row; i++){
            if(board[i][0]=='O'){
                q.add(new int[]{i,0});
                visited[i][0]=true;
            }
            if(board[i][col-1]=='O'){
                q.add(new int[]{i,col-1});
                visited[i][col-1]=true;
            }
        }
        for(int j = 1; j<col-1; j++){
            if(board[0][j]=='O'){
                q.add(new int[]{0, j});
                visited[0][j]=true;
            }
            if(board[row-1][j]=='O'){
                q.add(new int[]{row-1, j});
                visited[row-1][j]=true;
            }
        }

        int rc[] = {-1,0,1,0};
        int cc[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i = 0; i<4; i++){
                int ni = curr[0]+rc[i];
                int nj = curr[1]+cc[i];
                if(ni>=0 && ni<row && nj>=0 && nj<col && visited[ni][nj]==false && board[ni][nj]=='O'){
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }
        }
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j]=='O' && visited[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
}