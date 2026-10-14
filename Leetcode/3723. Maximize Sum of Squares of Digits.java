class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        if(num*9<sum || sum < 0 || num <= 0) {
            return "";
        }
        int rem = sum % 9;
        int quo = sum/9;
        if(quo>num || (quo==num && rem!=0)){
            return "";
        }
        for(int i=0; i<quo; i++) {
            sb.append('9');
        }

        if(quo<num){
            sb.append(rem);
            num--;
            for(int i=0; i<num-quo; i++) {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}