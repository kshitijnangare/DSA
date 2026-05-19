class Node{
    int val;
    int count;
    Node(int v, int c){
        val = v;
        count = c;
    }
}
class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        boolean[] visited = new boolean[1000];
        Queue<Node> q = new LinkedList<>();
        if(start==end){
            return 0;
        }
        
        q.add(new Node(start,0));
        visited[start] = true;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            int val = curr.val;
            int count = curr.count;
            for(int x: arr){
                int y = x * val;
                y = y % 1000;
                if(y==end){
                    return count + 1;
                }
                if(visited[y]==false){
                    q.add(new Node(y, count+1));
                    visited[y] = true;
                }
            }
        }
        return -1;
    }
}