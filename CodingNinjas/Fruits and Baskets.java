import java.util.*;
public class Solution {
    public static int findMaxFruits(int []arr, int n) {
        // Write your code here.
        int maxlen = 0;
        int lastFruit = -1, secondLastFruit = -1;
        int currCount = 0, lastFruitStreak = 0;
        for (int f : arr) {
            if (f == lastFruit || f == secondLastFruit) {
                currCount++;
            } else {
                currCount = lastFruitStreak + 1;
            }

            if (f == lastFruit) {
                lastFruitStreak++;
            } else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = f;
            }
            maxlen = Math.max(maxlen, currCount);
        }

        return maxlen;
    }
}