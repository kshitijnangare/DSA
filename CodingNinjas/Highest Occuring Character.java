public class Solution {

    public static char highestOccuringChar(String str) {
        // Step 1: Create a frequency table for the 26 lowercase English letters
        int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }
        
        // Step 2: Initialize trackers
        int maxFreq = 0;
        char result = str.charAt(0);
        
        // Step 3: Traverse the original string to automatically prioritize first occurrences
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(freq[ch - 'a'] > maxFreq){
                maxFreq = freq[ch - 'a'];
                result = ch;
            }
        }
        
        return result;
    }
}