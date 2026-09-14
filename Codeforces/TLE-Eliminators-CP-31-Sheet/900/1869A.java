import java.util.*;
import java.lang.*;
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
    public static void solve(BufferedReader br, PrintWriter pw) throws java.lang.Exception, IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x;
        boolean allZero = true;
        for(int i = 0; i<n; i++){
            x = Integer.parseInt(st.nextToken());
            if(allZero && x!=0){
                allZero=false;
            }
        }
        if(allZero){
            pw.println(0);
        }
        else if(n%2==0){
            pw.println(2);
            pw.println(1+" "+n);
            pw.println(1+" "+n);
        }else{
            pw.println(4);
            pw.println(1+" "+(n-1));
            pw.println(1+" "+(n-1));
            pw.println(2+" "+n);
            pw.println(2+" "+n);
        }
    }
}