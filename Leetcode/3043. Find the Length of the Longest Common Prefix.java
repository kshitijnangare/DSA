class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for(int x: arr1){
            while(x!=0){
                set.add(x);
                x=x/10;
            }
        }
        int max = 0;
        for(int x: arr2){
            // int len = length(x);
            int len = String.valueOf(x).length(); // This is optimum approach. 
            while(x!=0){
                if(set.contains(x)){
                    max = Math.max(len, max);
                    break;
                }
                len--;
                x=x/10;
            }
        }
        return max;
    }

    int length(int n){
        int len = 0;
        while(n!=0){
            n=n/10;
            len++;
        }
        return len;
    }
}