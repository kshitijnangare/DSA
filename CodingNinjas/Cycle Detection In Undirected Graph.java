import java.util.*;
class Pair{
    int curr;
    int parent;
    Pair(int c, int p){
        this.curr = c;
        this.parent = p;
    }
}
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int f = edges[i][0];
            int s = edges[i][1];
            list.get(f).add(s);
            list.get(s).add(f);
        }
        
        boolean[] visited = new boolean[n+1];
        String s = "No";
        for(int i = 1; i<=n; i++){
            if(visited[i]==false){
                if(dfs(list, i, -1, visited)==true){
                    s = "Yes";
                    break;
                }
            }
        }
        return s;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, int p, boolean[] visited){
        visited[s]= true;
        for(int x: adj.get(s)){
            if(visited[x]==false){
                boolean ans = dfs(adj, x, s, visited);
                if(ans==true){
                    return true;
                }
            }else{
                if(x!=p){
                    return true;
                }
            }
        }
        return false;
    }
    
}