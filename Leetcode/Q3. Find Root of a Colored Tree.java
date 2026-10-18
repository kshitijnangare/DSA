class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = colors.length();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n-1; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        for(int i=0; i<n; i++) {
            if (adj.get(i).size() <= 2) {
                if(bfs(i, adj, colors)){
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean bfs(int s, ArrayList<ArrayList<Integer>> adj, String colors){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[colors.length()];
        q.add(s);
        visited[s]=true;
        int scolor = getColorNum(colors.charAt(s));
        // r = 1, b = 2, w = 3
        while(!q.isEmpty()){
            int curr = q.poll();
            char currcolor = colors.charAt(curr);
            int currcolornum = getColorNum(currcolor);
            int childrencount = 0;
            
            for(int x: adj.get(curr)){
                if(visited[x]==false){
                    childrencount++;
                    visited[x]=true;
                    char xcolor = colors.charAt(x);
                    int xcolornum = getColorNum(xcolor);
                    if((currcolornum+1)%3 != xcolornum){
                        return false;
                    }
                    q.add(x);
                }
            }

            if(childrencount>2){
                return false;
            }
        }
        return true;
    }
    
    private int getColorNum(char c) {
        if (c=='R') return 0;
        if (c=='B') return 1;
        return 2;
    }
}