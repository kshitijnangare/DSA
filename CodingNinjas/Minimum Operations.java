import java.util.*;
class Pair{
    int n;
    int count;
    Pair(int f, int s){
        n = f;
        count = s;
    }
}

public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here
        if(start == end)return 0;
        boolean visited[] = new boolean[1000];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        visited[start]=true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int cn = curr.n;
            int count = curr.count;

            for(int x: a){
                int y = (x * cn) % 1000;
                if(y==end){
                    return count +1;
                }
                if(visited[y]==false){
                    q.add(new Pair(y, count+1));
                    visited[y]=true;
                }
            }
        }
        return -1;
    }
}