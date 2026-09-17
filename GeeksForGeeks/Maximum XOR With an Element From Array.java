class Trie{
    Trie[] children;
    public Trie(){
        children = new Trie[2];
    }
    
    public void insert(int num){
        Trie curr = this;
        for(int i = 31; i>=0; i--){
            int bit = (num >> i) & 1;
            
            if(curr.children[bit]==null){
                Trie temp = new Trie();
                curr.children[bit]=temp;
            }
            
            curr = curr.children[bit];
        }
    }
    
    public int getMaxXor(int num){
        Trie curr = this;
        int max = 0;
        for(int i = 31; i>=0; i--){
            int bit = (num>>i) & 1;
            int flipbit = bit ^ 1;
            if(curr.children[flipbit]!=null){
                max = max | (1<<i);
                curr = curr.children[flipbit];
            }else {
                curr = curr.children[bit];
            }
        }
        return max;
    }
}

class Solution {
    public int[] maxXor(int[] arr, int[][] queries) {
        // code here
        int m = queries.length;
        int n = arr.length;
        int[][] offline = new int[m][3];
        
        for(int i = 0; i<m; i++){
            offline[i][0] = queries[i][0];
            offline[i][1] = queries[i][1];
            offline[i][2] = i;
        }
        
        Arrays.sort(arr);
        Arrays.sort(offline, (a,b)->Integer.compare(a[1], b[1] ));
        
        int[] res =new int[m];
        int it = 0;
        Trie root = new Trie();
        for(int i = 0; i<m; i++){
            int xi = offline[i][0];
            int mi = offline[i][1];
            int ogi = offline[i][2];
            while(it<n && arr[it]<=mi){
                root.insert(arr[it]);
                it++;
            }
            if(it==0){
                res[ogi] = -1;
            }else{
                res[ogi] = root.getMaxXor(xi);
            }
            
        }
        return res;
    }
}