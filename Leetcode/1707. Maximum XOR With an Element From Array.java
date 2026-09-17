class Trie{
    Trie children[];
    public Trie(){
        children = new Trie[2];
    }

    public void insert(int num){
        Trie curr = this;
        for(int i = 31; i>=0; i--){
            int bit = (num>>i) & 1;
            if(curr.children[bit]==null){
                curr.children[bit]=new Trie();
            }
            curr = curr.children[bit];
        }
    }

    public int getMaxXor(int x){
        Trie curr = this;
        int max = 0;
        for(int i = 31; i>=0; i--){
            int bit = (x>>i) & 1;
            int flipbit = bit ^ 1;
            if(curr.children[flipbit]!=null){
                max = max | (1<<i);
                curr = curr.children[flipbit];
            }else{
                curr = curr.children[bit];
            }
        }
        return max;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int m = queries.length;
        int n = nums.length;
        int[][] offlineQueries = new int[m][3];
        for (int i = 0; i < m; i++) {
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1]; 
            offlineQueries[i][2] = i;             
        }

        Trie root = new Trie();

        Arrays.sort(nums);
        Arrays.sort(offlineQueries, (a, b) -> Integer.compare(a[1], b[1]));

        int it = 0;
        int[] res = new int[m];
        for(int i = 0; i<m; i++){
            int xi = offlineQueries[i][0];
            int ai = offlineQueries[i][1];
            int ogi = offlineQueries[i][2];
            while(it<n && nums[it]<=ai){
                root.insert(nums[it]);
                it++;
            }
            if (it == 0) {
                res[ogi] = -1;
            } else {
                int currmax = root.getMaxXor(xi);
                res[ogi] = currmax;
            }
        }
        return res;
    }
}