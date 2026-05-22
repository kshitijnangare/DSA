class Node{
    int f;
    int s;
    Node(int f, int s){
        this.f = f;
        this.s = s;
    }
}
class Solution {
    int cntOnes(int[][] grid) {
        // code here
        int row = grid.length;
        int col = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        int rc[] = {1,0,-1,0};
        int cc[] = {0,1,0,-1};
        
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    if(grid[i][j]==1 && visited[i][j]== false){
                        q.add(new Node(i,j));
                        visited[i][j] = true;
                        while(!q.isEmpty()){
                            Node curr = q.poll();
                            int r = curr.f;
                            int c = curr.s;
                            for(int x = 0; x<4; x++){
                                int nr = r+rc[x];
                                int nc = c+cc[x];
                                if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc]==1 && visited[nr][nc]==false){
                                    visited[nr][nc] = true;
                                    q.add(new Node(nr,nc));
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i<row-1; i++){
            for(int j = 1; j<col-1; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
};