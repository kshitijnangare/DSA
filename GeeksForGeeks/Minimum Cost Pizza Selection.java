class Solution {
    // recurssion
    // public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
    //     // code here
    //     int[][] pizzas = {{s,cs},{m,cm},{l,cl}};
    //     return recur(2, x, pizzas);
    // }
    // int recur(int i, int x, int[][] pizzas){
    //     if(x<=0){
    //         return 0;
    //     }
    //     if(i==0){
    //         int size = pizzas[i][0];
    //         int cost = pizzas[i][1];
    //         int count = x/size;
    //         if(x%size!=0){
    //             count++;
    //         }
    //         return count * cost;
    //     }
        
    //     int size = pizzas[i][0];
    //     int cost = pizzas[i][1];
        
    //     int notPick = 0 + recur(i-1, x, pizzas);
    //     int pick = cost + recur(i, x-size, pizzas);
    //     return Math.min(pick, notPick);
    // }
    
    
    // memoization
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
        int[][] pizzas = {{s,cs},{m,cm},{l,cl}};
        int[][] dp = new int[3][x+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return recur(2, x, pizzas, dp);
    }
    int recur(int i, int x, int[][] pizzas, int[][] dp){
        if(x<=0){
            return 0;
        }
        if(i==0){
            int size = pizzas[i][0];
            int cost = pizzas[i][1];
            int count = x/size;
            if(x%size!=0){
                count++;
            }
            return count * cost;
        }
        if(dp[i][x]!=-1){
            return dp[i][x];
        }
        
        int size = pizzas[i][0];
        int cost = pizzas[i][1];
        
        int notPick = 0 + recur(i-1, x, pizzas, dp);
        int pick = cost + recur(i, x-size, pizzas, dp);
        return dp[i][x] = Math.min(pick, notPick);
    }
}