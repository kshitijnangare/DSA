import java.util.*;
public class Main{
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(); 
        while (t-- > 0) {
            int l = input.nextInt();
            int r = input.nextInt();
            int result = coprimes(l, r);
            System.out.println(result);
        }
        input.close();
    }
 
    public static int coprimes(int l, int r){
        if(l==r){
            if(l==1){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return r-l;
        }
    }
}