import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        while (t-- > 0) {
            String res = helper(sc);
            System.out.println(res);
        }
        sc.close();
    }
    public static String helper(Scanner sc){
        String s = sc.next();
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                count0++;
            }else{
                count1++;
            }
        }
        int min = Math.min(count0, count1);
        if(min%2==1){
            return "DA";
        }else{
            return "NET";
        }
    }
}