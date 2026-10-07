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
 
        String s = br.readLine();
 
        TreeSet<Integer> set = new TreeSet<>();
 
        Stack<Integer> st = new Stack<>();
 
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
 
            if(c=='1'){
                st.push(i+1);
            }else if(c=='2'){
                if(!st.isEmpty()){
                    st.pop();
                    set.add(i+1);
                }else{
                    continue;
                }
            }else{
                continue;
            }
        }
 
        while(!st.isEmpty()){
            set.add(st.pop());
        }
 
        pw.println(set.size());
        for(int x: set){
            pw.print(x+" ");
        }
        pw.println();
        
    }
}