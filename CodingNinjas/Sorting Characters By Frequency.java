import java.util.*;
class Pair {
    int freq;
    char ch;
    Pair(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }
}
public class Solution {
    public static String sortByFrequency(int n, String s) {
        // Write Your Code here
        Pair[] freq = new Pair[256];
        for (int i = 0; i < 256; i++) {
            freq[i] = new Pair(0, (char) i);
        }

        for (char ch : s.toCharArray()) {
            freq[ch].freq++;
        }

        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) {
                return Integer.compare(p2.freq, p1.freq); 
            }
            return Character.compare(p1.ch, p2.ch);
        });

        StringBuilder result = new StringBuilder();
        for (Pair p : freq) {
            if (p.freq > 0) {
                char[] temp = new char[p.freq];
                Arrays.fill(temp, p.ch);
                result.append(temp);
            } 
        }
        return result.toString();
    }
}