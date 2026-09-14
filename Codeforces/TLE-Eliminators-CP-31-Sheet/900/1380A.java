import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = false;
            int prev=0;
            int curr=0;
            int next=0;
            for(int i = 1; i<n-1; i++){
                prev = arr[i-1];
                curr = arr[i];
                next = arr[i+1];
                if(prev<curr && curr>next){
                    prev = i;
                    curr=i+1;
                    next = i+2;
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
                System.out.println(prev+ " "+curr+" "+next);
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}