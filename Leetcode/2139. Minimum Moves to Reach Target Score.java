class Solution {
    public int minMoves(int target, int maxDoubles) {
        int curr = target;
        int ops = 0;
        if(maxDoubles == 0){
            return target-1;
        }
        while(curr!=1){
            if(curr%2==1){
                curr=curr-1;
                ops++;
            }else {
                if(maxDoubles-->0){
                    curr = curr/2;
                    ops++;
                }else{
                    ops = ops+curr-1;
                    break;
                }
            }
        }
        return ops;
    }
}