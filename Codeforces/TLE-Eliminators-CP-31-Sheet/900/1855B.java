import java.lang.*;
import java.util.*;
import java.io.*;
 
public class Main{
    public static void main(String[] args) throws java.lang.Exception, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            solve(br, pw);
        }
        pw.flush();
        pw.close();
        br.close();
    }
    public static void solve(BufferedReader br,PrintWriter pw) throws java.lang.Exception, IOException{
        long n = Long.parseLong(br.readLine());
        int count = 0;
        long i  = 1;
        while(n%i==0){
            count++;
            i++;
        }
        pw.println(count);
    }
}