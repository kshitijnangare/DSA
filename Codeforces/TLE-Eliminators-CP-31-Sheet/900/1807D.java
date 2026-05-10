import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] arr = new int[n+1];
            arr[0] = 0;
            int arr_sum = 0;
            for (int i = 1; i < n+1; i++) {
                int x = sc.nextInt();
                arr_sum += x;
                arr[i] = arr_sum;
            }


            for(int i = 0; i<q; i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                int k_sum = k*(r-l+1);

                int sum_of_replacing_num = arr[r] - arr[l-1];

                String res = (arr_sum-sum_of_replacing_num+k_sum)%2==0 ? "No" : "Yes";
                System.out.println(res);


            }
        }
        sc.close();
    }
}


//basic math rule
// even + even = even (4+8=12) // no
// odd + odd = even (7+5=12) // no
// odd + even = odd (7+8=15) // yes

//   1 2 3 4  5  6  7  8  9  10 // arr
// 0 1 3 6 10 15 21 28 36 45 55 // arr_sum (n+1)

// Example test case
// 5 5
//   2 2 1 3 2 (arr) sum = 10
// 0 2 4 5 8 10 (arr_sum)

// 2 3 3 (l r k) -> sum_of_replacing_num = arr[r] - arr[l-1]; = 5 - 2 = 3; 10-3+6 = 13 = YES
// 2 3 4 (l r k) -> sum_of_replacing_num = arr[r] - arr[l-1]; = 5 - 2 = 3; 10-3+8 = 15 = YES
// 1 5 5 (l r k) -> sum_of_replacing_num = arr[r] - arr[l-1]; = 10 - 0 = 10; 10-10+25 = 25 = YES