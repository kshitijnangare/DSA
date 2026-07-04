class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr, (a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int n = arr.length;
        
        int[] range = arr[0];
        for(int i = 1; i<n; i++){
            int prev1 = range[0];
            int next1 = range[1];
            int prev2 = arr[i][0];
            int next2 = arr[i][1];
            
            if(next1<prev2){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(prev1);
                temp.add(next1);
                range = arr[i];
                res.add(temp);
            }else{
                range[0] = Math.min(prev1, prev2);
                range[1] = Math.max(next1, next2);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(range[0]);
        temp.add(range[1]);
        res.add(temp);
        return res;
    }
}