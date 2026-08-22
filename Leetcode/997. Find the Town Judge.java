class Solution {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        for(int i = 0; i<len; i++){
            int f = trust[i][0]-1;
            int s = trust[i][1]-1;
            adj.get(f).add(s);
            adj2.get(s).add(f);
        }
        int count = 0;
        int judge = -1;
        for(int i = 0; i<adj.size(); i++){
            if(adj.get(i).size()==0){
                judge = i+1;
                count++;
            }
        }
        if(count==1){
            if(adj2.get(judge-1).size()==n-1){
                return judge;
            }
        }
        return -1;
    }
}