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
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int maxkey = 0;
        int maxfreq = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()>maxfreq){
                maxkey = e.getKey();
                maxfreq = e.getValue();
            }
        }
        int subtractor = maxfreq;
        int remaining = n-maxfreq;
        int count = 0;
        while(remaining>0){
            count++;
            int adder = maxfreq<=remaining ? maxfreq : remaining;
            count+=adder;
            remaining -= maxfreq;
            maxfreq*=2;
        }
        pw.println(count);
    }
}