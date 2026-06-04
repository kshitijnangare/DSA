class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num1<100 && num2<100){
            return 0;
        }
        if(num1<100 && num2>=100){
            num1=100;
        }
        int wavy=0;
        for(int i = num1; i<=num2; i++){
            wavy+=MoholPuraWavy(i);
        }
        return wavy;

    }
    public int MoholPuraWavy(int x){
        int prev = x%10;
        x=x/10;
        int count = 0;
        while(x!=0){
            int curr = x%10;
            x=x/10;
            if(x==0){
                return count;
            }
            int next = x%10;
            if(curr>prev && curr>next){
                count++;
            }
            if(curr<next && curr<prev){
                count++;
            }
            prev = curr;
        }
        return count;
    }
}