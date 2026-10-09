import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{   
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br, pw);
        }

        pw.flush();
        pw.close();
        br.close();
	}

    public static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        String string = br.readLine();
        String[] carr = string.split(" ");
        String s = carr[0];
        String t = carr[1];

        int n = s.length();
        int m = t.length();
        HashSet<Integer> reservedIndex = new HashSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = m-1; i>=0; i--){
            char find = t.charAt(i);
            int j= n-1;
            while(j>=0){
                if(s.charAt(j)==find && !reservedIndex.contains(j)){
                    reservedIndex.add(j);
                    map.put(i,j);
                    break;
                }
                j--;
            }
            if(j<0){
                pw.println("NO");
                return;
            }
        }
        int currval = map.get(0);
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int val = e.getValue();
            if(currval>val){
                pw.println("NO");
                return;
            }
            currval=val;
        }
        pw.println("YES");
    }
}


// my thinking
// the letter in the t needs to be last occurence of the word s
// PSEUDOPSEUDOHYPOPARATHYROIDISM PEPA
// PSEUDOPSE U D O H Y P O P A R A T H Y R O I D I S M
// 123456789101112131415161718192021222324252627282930

// here 
// A -> 20
// P -> 17
// E -> 9
// P -> since 17 was already used use next last occurence = 15

// now the index should be in order P<E<P<A
// but it is not return false

// DEINSTITUTIONALIZATION DONATION
// DEINSTITU T I O N A L I Z A T I O N
// 12345678910111213141516171819202122

// here if you see the index are in order D<O<N<A<T<I<O<N 
// hence return true


// another method from GPT
// import java.util.*;
// import java.io.*;

// public class Main {   
//     public static void main (String[] args) throws java.lang.Exception, IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter pw = new PrintWriter(System.out);
        
//         int t = Integer.parseInt(br.readLine());
//         while (t-- > 0) {
//             solve(br, pw);
//         }

//         pw.flush();
//         pw.close();
//         br.close();
//     }

//     public static void solve(BufferedReader br, PrintWriter pw) throws IOException {
//         String string = br.readLine();
//         String[] carr = string.split(" ");
//         String s = carr[0];
//         String t = carr[1];

//         // Arrays to store the frequency of each character (A-Z)
//         int[] countS = new int[26];
//         int[] countT = new int[26];

//         for (int i = 0; i < s.length(); i++) countS[s.charAt(i) - 'A']++;
//         for (int i = 0; i < t.length(); i++) countT[t.charAt(i) - 'A']++;

//         int[] deleteCount = new int[26];
//         for (int i = 0; i < 26; i++) {
//             // If 't' requires more of a character than 's' has, it's impossible
//             if (countT[i] > countS[i]) {
//                 pw.println("NO");
//                 return;
//             }
//             // Calculate exactly how many of each character we MUST delete
//             deleteCount[i] = countS[i] - countT[i];
//         }

//         // Reconstruct the string after mandatory deletions
//         StringBuilder remainingString = new StringBuilder();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
            
//             // If we still need to delete this character, skip it
//             if (deleteCount[c - 'A'] > 0) {
//                 deleteCount[c - 'A']--;
//             } else {
//                 // Otherwise, this character survives
//                 remainingString.append(c);
//             }
//         }

//         // If the surviving characters exactly form 't', it's valid
//         if (remainingString.toString().equals(t)) {
//             pw.println("YES");
//         } else {
//             pw.println("NO");
//         }
//     }
// }