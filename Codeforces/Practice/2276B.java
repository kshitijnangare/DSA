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
        String s = br.readLine();
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1; // already by doing nothing
        // int blocklen = 1;
        List<Integer> blocklen = new ArrayList<>();
        int i = 0;
        while (i<n) {
            int j=i;
            while(j<n && s.charAt(j)==s.charAt(i)) {
                j++;
            }
            blocklen.add(j-i);
            i=j;
        }
        int k = blocklen.size();
        for(i = 0; i<k; i++){
            int len = blocklen.get(i);

            if(len>=3){
                count++;
                break;
            }
        }

        for(i = 1; i<k-1; i++){
            int len = blocklen.get(i);
            if(len==1){
                count++;
                break;
            }
        }
        pw.println(count);

    }
}


// my thinking
// here I have 2 intutions.
// brute force. time complezity may work here. like take every character, replace with opposite and then compress and add to hashset. then return count of size of hashset at last
// second is just maths. like if there are 2 consecutive 00 then it makes 1 single string. if its like 111 then it makes 2 types of string. so add 2 to count like that.
// suppose the string is 100111011
// first and last character remains same 
// middle characters are 0011101 
// now with this we have to work it compresses to 0101 (no replace)
// or it will compress to 010101 (replace the middle 1 from 111)
// or it will compress to 01 (replace the second last 0)

// it means if 2 consective same numbers--> has no effect 
// 3 or morer consecutive same numbers --> generate 1 different string
// and one single number between 2 different number --> generate new string

// solution fails for 001011010
// decoding
// blocklen list becomes [2,1,1,2,1,1,1]
// first loop that checks len>=3 count does not increase
// but in second loop the count increase to count+=4 ==>5

// suppose i think no matter how many singles are there between
// two diff numbers they can always make max 1 diff string