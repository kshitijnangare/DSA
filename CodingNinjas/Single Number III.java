import java.util.* ;
import java.io.*; 
public class Solution {
    public static void twoNonRepeatingElements(int arr[], int n) {
        // Write your code here.
        int xor = 0;
        for(int x: arr){
            xor = xor^ x;
        }
        int k = (xor & (~(xor-1)));
        int res1= 0;
        int res2=0;
        for(int x: arr){
            if((x & k)!=0){
                res1=res1^x;
            }else{
                res2=res2^x;
            }
        }
        if(res1>res2){
            int t = res1;
            res1=res2;
            res2=t;
        }
        System.out.println(res1+" "+res2);
    }
}
