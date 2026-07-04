public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		StringBuilder res = new StringBuilder();
        int n = str.length();
        int i = n - 1;
        
        while (i >= 0) {
            while (i >= 0 && str.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;
            int j = i;
            while (i >= 0 && str.charAt(i) != ' ') {
                i--;
            }
            if (res.length() > 0) {
                res.append(" "); 
            }
            res.append(str.substring(i + 1, j + 1));
        }
        return res.toString();
	}
}
