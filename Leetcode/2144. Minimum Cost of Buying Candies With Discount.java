class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;
        int n = cost.length;
        if(n==2){
            totalCost+=cost[0]+cost[1];
            return totalCost;
        }
        if(n==1){
            return cost[0];
        }
        for(int i = n-3; i>-3; i=i-3){
            if(i+1>=0){
                totalCost+=cost[i+1];
            }
            if(i+2>=0){
                totalCost+=cost[i+2];
            }
        }
        return totalCost;
    }
}