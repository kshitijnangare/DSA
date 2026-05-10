import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();
            String s = sc.next();

            int cons = 1;
            int curr_cons = 1;
            for(int i = 0; i<n-1; i++){
                char pre = s.charAt(i);
                char nex = s.charAt(i+1);

                if(pre==nex){
                    curr_cons++;
                    cons = Math.max(curr_cons, cons);
                }else{
                    curr_cons=1;
                }
            }

            if(cons==1){
                System.out.println(2);
            }else{
                System.out.println(cons+1);
            }

        }
        
    }
}