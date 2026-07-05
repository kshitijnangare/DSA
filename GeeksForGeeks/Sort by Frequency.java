class Pair{
    char ch;
    int freq;
    Pair( int f, char c){
        this.ch = c;
        freq = f;
    }
}
class Solution {
    public String frequencySort(String s) {
        // code here
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char)(i + 'a'));
        }
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) return p1.freq - p2.freq;
            return p1.ch - p2.ch;
        });

        StringBuilder result = new StringBuilder();
        for (Pair p : freq) {
            if (p.freq > 0){
                char[] temp = new char[p.freq];
                Arrays.fill(temp,p.ch);
                result.append(temp);
            } 
        }
        return result.toString();
    }
};