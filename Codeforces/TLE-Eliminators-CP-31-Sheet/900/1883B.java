import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
 
            int[] freq = new int[26];
            for(int i = 0; i<n; i++){
                freq[s.charAt(i)-'a']++;
            }
            long odd_freq = 0;
            for(int i = 0; i<26; i++){
                odd_freq = odd_freq + freq[i] % 2;
            }
 
            if(odd_freq>k+1){
                System.out.println("No");
            }else{
                System.out.println("Yes");
 
            }
        }
        
    }
}