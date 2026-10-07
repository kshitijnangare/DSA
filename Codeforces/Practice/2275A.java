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
        int n = Integer.parseInt(br.readLine());
 
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = n - 4;
        if (m <= 0) {
            pw.println(0);
            return;
        }
        // if(n<=5){
        //     pw.println(0);
        //     return;
        // }
        int[] triadscore = new int[n-4];
 
        HashMap<Integer, Long> map = new HashMap<>();
 
        for(int i = 0; i<m; i++){
            int f= arr[i];
            int s = arr[i+2];
            int t = arr[i+4];
            int score = f+s-t;
            triadscore[i]=score;
            map.put(score, map.getOrDefault(score, 0L)+1L);
        }
        long ans = 0;
        for(long freq : map.values()) {
            ans+=freq*(freq-1)/2;
        }
 
        for(int i = 0; i<m; i++){
            int curr = triadscore[i];
            if (i+2<m && curr==triadscore[i+2]) {
                ans--;
            }
            if (i+4<m && curr==triadscore[i+4]) {
                ans--;
            }
        }
        pw.println(ans);
    }
}