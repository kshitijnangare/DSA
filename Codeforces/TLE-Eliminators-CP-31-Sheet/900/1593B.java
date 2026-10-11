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
        long n = Long.parseLong(br.readLine());
        long MAX_VALUE = 1000000009;
        long min = MAX_VALUE;
        
        // check for 00
        long rightdrop = 0;
        long x = n;
        while(x!=0){
            long last = x%10;
            if(last==0){
                break;
            }
            x=x/10;
            rightdrop++;
        }
        x=x/10;
        long middrop = 0;
        while(x!=0){
            long last = x%10;
            if(last==0){
                break;
            }
            x=x/10;
            middrop++;
        }
        long localmin = middrop+rightdrop;
        min = Math.min(localmin, min);

        // check for 50
        rightdrop = 0;
        x = n;
        while(x!=0){
            long last = x%10;
            if(last==0){
                break;
            }
            x=x/10;
            rightdrop++;
        }
        x=x/10;
        middrop = 0;
        while(x!=0){
            long last = x%10;
            if(last==5){
                break;
            }
            x=x/10;
            middrop++;
        }
        localmin = middrop+rightdrop;
        min = Math.min(localmin, min);

        // check for 25
        rightdrop = 0;
        x = n;
        while(x!=0){
            long last = x%10;
            if(last==5){
                break;
            }
            x=x/10;
            rightdrop++;
        }
        x=x/10;
        middrop = 0;
        while(x!=0){
            long last = x%10;
            if(last==2){
                break;
            }
            x=x/10;
            middrop++;
        }
        localmin = middrop+rightdrop;
        min = Math.min(localmin, min);

        // check for 75
        rightdrop = 0;
        x = n;
        while(x!=0){
            long last = x%10;
            if(last==5){
                break;
            }
            x=x/10;
            rightdrop++;
        }
        x=x/10;
        middrop = 0;
        while(x!=0){
            long last = x%10;
            if(last==7){
                break;
            }
            x=x/10;
            middrop++;
        }
        localmin = middrop+rightdrop;
        min = Math.min(localmin, min);

        pw.println(min);
    }
}