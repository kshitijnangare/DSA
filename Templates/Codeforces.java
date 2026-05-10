import java.util.Scanner;
import java.util.Arrays; 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            // 1. Single-Digit Integer Input (or any single integer)
            // int n = sc.nextInt();
        

            // 2. Multiple-Digit Integers in a Single Line
            // int n = sc.nextInt();
            // int k = sc.nextInt();

            // 3. String Input (single word)
            
            // String word = sc.next(); // Reads a single token (word) until whitespace

            // 4. String Input (entire line with spaces)
            // This is a sentence.
            // IMPORTANT: If you read an int/double/next() before nextLine(),
            // you might need an extra sc.nextLine() to consume the leftover newline character.
            // This is because nextInt(), next(), etc., don't consume the newline.
            // sc.nextLine(); // Consume the leftover newline from previous nextInt() calls
            // String sentence = sc.nextLine(); // Reads the entire line until the newline character

            // 5. Array Input (fixed size)
            // int[] arr = new int[n];
            // for (int i = 0; i < n; i++) {
            //     arr[i] = sc.nextInt();
            // }
            // System.out.println();
        }
        sc.close();
    }
}