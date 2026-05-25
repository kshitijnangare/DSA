class Solution {
    public String largestNumber(int n, int sum) {
        // code here
        if(sum>n*9){
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        
        while(sum!=0){
            if(sum>=9){
                sb.append('9');
                sum = sum-9;
            }else{
                sb.append(sum);
                sum = 0;
            }
            n--;
        }
        while(n>0){
            sb.append('0');
            n--;
        }
        return sb.toString();
    }
}
