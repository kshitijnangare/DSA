class Node{
    int f;
    int s;
    Node(int f, int s){
        this.f = f;
        this.s = s;
    }
}

class Solution {
    // Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid) {
        // code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        
        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 'X' && visited[i][j]==false){
                    q.add(new Node(i,j));
                    visited[i][j] = true;
                    count++;
                    helper(grid, visited, q, row, col);
                }
            }
        }
        return count;
    }
    
    void helper(char[][] grid, boolean[][] visited, Queue<Node> q, int row, int col){
        int r[] = {1, 0, -1, 0};
        int c[] = {0, -1, 0, 1};
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int f = curr.f;
            int s = curr.s;
            for(int i = 0; i<4; i++){
                int nf = f+r[i];
                int ns = s+c[i];
                if(nf>=0 && nf<row && ns>=0 && ns<col && grid[nf][ns] == 'X' && visited[nf][ns]==false){
                    visited[nf][ns] = true;
                    q.add(new Node(nf, ns));
                }
            }
            
        }
    }
}