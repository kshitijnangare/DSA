class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for(int i  = 1; i<=n; i++){
            set.add(i);
        }
        for(int i = n-1; i>=0; i--){
            int insert = set.size();
            res[i] = insert;
            set.remove(A[i]);
            set.remove(B[i]);
        }
        return res;
    }
}
