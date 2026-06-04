class Solution {
    int maxSubstring(String s) {
        // code here
        int count = -1;
        int max = -1;
        for(int i = 0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c=='1'){
                if(count==-1){
                    continue;
                }else{
                    count--;
                }
            }else{
                if(count==-1){
                    count=1;
                }else{
                    count++;
                }
            }
            
            max = Math.max(count,max);
        }
        return max;
    }
}