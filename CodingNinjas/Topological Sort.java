import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        // topo sort using BFS
        int[] indegree = new int[v];
        Arrays.fill(indegree,0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.size(); i++){
            int f = edges.get(i).get(0);
            int s = edges.get(i).get(1);
            adj.get(f).add(s);
        }
        for(ArrayList<Integer> ed: edges ){
            indegree[ed.get(1)]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i =0; i<v; i++){
            if(indegree[i]==0){
                q.add(i);
                res.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int x: adj.get(curr)){
                indegree[x]--;
                if(indegree[x]==0){
                    res.add(x);
                    q.add(x);
                }
            }
        }
        return res;
    }
}
