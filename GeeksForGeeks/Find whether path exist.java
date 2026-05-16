
class Node{
    int f;
    int s;
    Node(int first, int second){
        f = first;
        s = second;
    }
}

class Solution {
    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1){
                    q.add(new Node(i,j));
                    break;
                }
            }
        }
        
        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};
        boolean res = false;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int f = curr.f;
            int s = curr.s;
            
            for(int i = 0; i<4; i++){
                int nr = f+r[i];
                int nc = s+c[i];
                
                if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc] == 2){
                    res = true;
                    break;
                }
                if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc] == 3 && visited[nr][nc] == false){
                    q.add(new Node(nr,nc));
                    visited[nr][nc] = true;
                }
                
            }
            if(res == true){
                break;
            }
        }
        return res;
    }
}