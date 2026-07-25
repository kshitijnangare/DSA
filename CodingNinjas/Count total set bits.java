public class Solution{
    public static int countSetBits(int n) {
        if (n == 0) {
            return 0;
        }

        int x = largestPowerOf2(n);
        
        int bitsUpTo2X = x * (1 << (x - 1));
        int msbFrom2XToN = n - (1 << x) + 1;
        int remaining = countSetBits(n - (1 << x));

        return bitsUpTo2X + msbFrom2XToN + remaining;
    }

    private static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }
        return x;
    }
}