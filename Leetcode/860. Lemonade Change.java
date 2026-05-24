class Solution {
    public boolean lemonadeChange(int[] bills) {
        int N5 = 0, N10 = 0, N20 = 0;
        for(int x: bills){
            if(x==5){
                N5++;
            }else if(x==10){
                N5--;
                N10++;
            }else{
                if(N10!=0){
                    N10--;
                    N5--;
                }else{
                    N5=N5-3;
                }
            }

            if(N5<0 || N10<0 || N20<0){
                return false;
            }
        }
        return true;
    }
}