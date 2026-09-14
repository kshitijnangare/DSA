import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        while (t-- > 0) {
            int res = helper(sc);
            System.out.println(res);
        }
        sc.close();
    }
    public static int helper(Scanner sc){
        int n = sc.nextInt();
        if(n==1){return 0;}
            
        int fact2 = 0;
        while(n%2==0){
            if(n==0){
                break;
            }
            fact2++;
            n=n/2;
        }
        int fact3=0;
        while(n%3==0){
            if(n==0){
                break;
            }
            fact3++;
            n=n/3;
        }
        if(n!=1){
            return -1;
        }
        
        if(fact2>fact3){
            return -1;
        }
        return fact3 + (fact3-fact2);
            
    }
}