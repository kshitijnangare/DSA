import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int maxOps = 2*n;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i<n; i++){
                if(arr[i]==1){
                    arr[i]++;
                    maxOps--;
                }
            }

            for(int i = 0; i<n-1; i++){
                if(arr[i+1] % arr[i] == 0){
                    arr[i+1]++;
                    maxOps--;
                }
            }

            for(int x: arr){
                System.out.print(x+" ");
            }
            System.out.println("");

        }
        sc.close();
    }
}