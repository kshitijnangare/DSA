class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        for(int i = 1; i<n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0; j<res.get(i-1).size()-1; j++){
                temp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res.get(n-1);
    }
}