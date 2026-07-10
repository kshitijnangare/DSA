import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int x: boards){
            low = Math.max(low, x);
            high = high + x;
        }
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(helper(boards, k, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean helper(ArrayList<Integer> boards, int k, int mid){
        int count = 1;
        int sum = 0;
        for(int x: boards){
            if(sum+x<=mid){
                sum +=x;
            }else{
                sum =x;
                count++;
            }
        }
        return count<=k;
    }
}