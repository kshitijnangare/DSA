class Node{
    int f, s, t;
    Node(int first, int second, int third){
        f = first;
        s = second;
        t = third;
    }
}

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        
        for(int i =0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(visited[i][j] == false && grid[i][j] == 'L'){
                   count = helper(visited, grid, i, j, count);
                }
            }
        }
        return count;
    }
    
    public int helper(boolean[][] visited, char[][] grid, int i, int j, int count){
        Queue<Node> q = new LinkedList<Node>();
        count = count + 1;
        q.add(new Node(i, j, count));
        int row = visited.length;
        int col = visited[0].length;
        
        int[] r = {-1,-1,-1, 0,0, 1,1,1};
        int[] c = {-1, 0, 1,-1,1,-1,0,1};
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int f = curr.f;
            int s = curr.s;
            int t = curr.t;
            for(int k = 0; k<8; k++){
                int ff = f;
                int ss = s;
                ff = ff+r[k];
                ss = ss+c[k];
                if( ff>=0 && ff<row && ss>=0 && ss<col && visited[ff][ss] == false && grid[ff][ss] == 'L'){
                    q.add(new Node(ff,ss, t));
                    visited[ff][ss] = true;
                }
            }
        }
        return count;
    }
}