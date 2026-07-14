class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        for(int i = 0; i<n; i++){
            dp[i]=1;
            hash[i]=i;
        }
        
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(arr[i]%arr[prev]==0){
                    if(dp[i] < dp[prev]+1){
                        dp[i]= dp[prev]+1;
                        hash[i]=prev;
                    }
                    else if(dp[i] == dp[prev] + 1){
                        if(isLexGreater(arr, hash, prev, hash[i])){
                            hash[i] = prev;
                        }
                    }
                }
            }
        }
        
        int maxInd=0;
        int max = -1;
        for(int i =0; i<n; i++){
            if(max < dp[i]){
                maxInd = i;
                max = dp[i];
            }
            else if(max == dp[i]){
                if(isLexGreater(arr, hash, i, maxInd)){
                    maxInd = i;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(hash[maxInd]!=maxInd){
            list.add(arr[maxInd]);
            maxInd = hash[maxInd];
        }
        list.add(arr[maxInd]);
        Collections.reverse(list);
        return list;
    }
    
    private boolean isLexGreater(int[] arr, int[] hash, int i, int j){
        ArrayList<Integer> list1 = build(arr, hash, i);
        ArrayList<Integer> list2 = build(arr, hash, j);
        
        int n = Math.min(list1.size(), list2.size());
        for(int k = 0; k < n; k++){
            if(!list1.get(k).equals(list2.get(k))){
                return list1.get(k) > list2.get(k);
            }
        }
        return list1.size() > list2.size();
    }
    
    private ArrayList<Integer> build(int[] arr, int[] hash, int ind){
        ArrayList<Integer> temp = new ArrayList<>();
        while(hash[ind] != ind){
            temp.add(arr[ind]);
            ind = hash[ind];
        }
        temp.add(arr[ind]);
        Collections.reverse(temp);
        return temp;
    }
}