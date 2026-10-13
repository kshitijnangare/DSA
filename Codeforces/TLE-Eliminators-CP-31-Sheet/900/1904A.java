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
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int xk = Integer.parseInt(st1.nextToken());
        int yk = Integer.parseInt(st1.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int xq = Integer.parseInt(st2.nextToken());
        int yq = Integer.parseInt(st2.nextToken());

        // int count = 0;
        // boolean reach = false;
        // int[] dx = {a, a, -a, -a, b, b, -b, -b};
        // int[] dy = {b, -b, b, -b, a, -a, a, -a};

        // for(int i = 0; i<8; i++){
        //     int firstxjump = dx[i];
        //     int firstyjump = dy[i];
        //     int secondxjump = 0;
        //     int secondyjump = 0;

        //     for(int j=0;j<8;j++){
        //         secondxjump=dx[j];
        //         secondyjump=dy[j];
        //         int finalx = xk+firstxjump+secondxjump;
        //         int finaly = yk+firstyjump+secondyjump;
        //         if(finalx==xq && finaly==yq){
        //             reach = true;
        //             count++;
        //         }
        //     }
        // }
        // pw.println(count);

        int count = 0;
        HashSet<String> kingsquare = new HashSet<>();
        HashSet<String> queensquare = new HashSet<>();
        int[] dx = {a, a, -a, -a, b, b, -b, -b};
        int[] dy = {b, -b, b, -b, a, -a, a, -a};

        for(int i = 0; i<8; i++){
            int x = xk + dx[i];
            int y = yk + dy[i];
            kingsquare.add(x+","+y);
        }

        for(int i = 0; i<8; i++){
            int x = xq + dx[i];
            int y = yq + dy[i];
            queensquare.add(x+","+y);
        }

        for(String s: kingsquare){
            if(queensquare.contains(s)){
                count++;
            }
        }

        pw.println(count);
    }
}


// my thinking
// lets think this way
// instead of finding the knight position, we will find if one can reach queen from king 
// in two knight moves

// for eg king(0,0) queen(3,3) and knight moves (2,1) means 2 step in one direction 
// and 1 in other
// lets move 2 in x and 1 in y from king --> (2,1) --> now lets move again 2 in x and 1 in y --> (4,2)
// no this is not the one lets try again
// 2 in x and 1 in y --> (2,1) --> 1 in x and 2 in y --> (3,3) --> found queen
// means now there are ways we can reach it ans is nonzero

// now how many ways? trying out all possible things I found there can be maximum 2 ways
// if x!=y in knight moves(x,y) --> two ways
// else 1 way. 
// that technique gives wrong answer idk y
// my second itution tells me 
// find all the squares that the knight can reach from king --> kingsquare
// find all the sqaures that the knight can reach from queen --> queensquare
// find the common count and return