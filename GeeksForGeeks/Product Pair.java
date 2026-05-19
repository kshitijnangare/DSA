class Solution {
    public boolean isProduct(int[] arr, long target) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int x: arr){
            if(target==0 & x==0){
                return true;
            }
            if(x==0){
                set.add(x);
                continue;
            }
            if(target % x == 0 && x!=0){
                int n = (int) (target / x);
                if(set.contains(n)){
                    return true;
                }
            }
            set.add(x);
        }
        return false;
    }
}