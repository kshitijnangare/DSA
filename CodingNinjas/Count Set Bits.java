
public class Solution 
{
    public static int countSetBits(int n) 
    {
        //    Write your code here.
        int ans = 0;
        for(int i = 1; i<=n; i++){
            int x = i;
            while(x>0){
                x=x & (x-1);
                ans++;
            }
        }
        return ans;
    }
}