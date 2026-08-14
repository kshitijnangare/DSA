class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        int len = 0, maxlen = 0;
        int j = 0;
        for(int i = 0; i<s.length(); i++){
            char c= s.charAt(i);
            int ind = c-'a';
            arr[ind]++;
            if(arr[ind]>2){
                while(s.charAt(j)!=c){
                    char cr = s.charAt(j);
                    int rind = cr-'a';
                    arr[rind]--;
                    j++;
                }
                arr[ind]--;
                j++;
            }
            len = i-j+1;
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
}