class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c=='*'){
                len = Math.max(0, len-1);
            }else if(c=='#'){
                len = len*2;
            }else if(c=='%'){
                continue;
            }else{
                len = len+1;
            }
        }

        if (k >= len) {
            return '.';
        }

        for(int i = n-1; i>=0; i--){
            char c = s.charAt(i);
            if(c=='#'){
                len = len/2;
                k = k>=len ? k-len : k;
            }else if(c=='%'){
                k = len-k-1;
            }else if(c=='*'){
                len++;
            }else{
                len--;
            }
            if (k == len) {
                return c;
            }
        }

        return '.';
    }
}