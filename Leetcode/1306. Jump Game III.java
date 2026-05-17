class Node{
    int ind;
    int val;
    Node(int i, int v){
        ind = i;
        val = v;
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        if(arr[start]==0){
            return true;
        }
        boolean[] visited = new boolean[len];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, arr[start]));
        visited[start] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();
            int ind = curr.ind;
            int val = curr.val;
            int nextInd = ind+val;
            int prevInd = ind-val;
            if(nextInd<len && arr[nextInd] == 0){
                return true;
            }
            if(prevInd>=0 && arr[prevInd] == 0){
                return true;
            }
            if(nextInd<len && visited[nextInd] == false){
                q.add(new Node(nextInd, arr[nextInd]));
                visited[nextInd] = true;
            }
            if(prevInd>=0 && visited[prevInd] == false){
                q.add(new Node(prevInd, arr[prevInd]));
                visited[prevInd] = true;
            }
        }
        return false;
    }
}