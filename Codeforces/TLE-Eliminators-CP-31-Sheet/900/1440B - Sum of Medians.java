import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n*k];
            for (int i = 0; i < n*k; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int step = n - (n + 1) / 2 + 1;
            long sum = 0;
            int i = n*k-step;
            while(k-->0){
                sum += arr[i];
                i = i - step;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
