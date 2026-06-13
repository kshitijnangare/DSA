class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<words.length; i++){
            int thisWordWeight = 0;
            for(int j = 0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                int ic = (int)c;
                int ind = ic-97;
                thisWordWeight += weights[ind];
            }
            thisWordWeight = thisWordWeight % 26;
            int letterAscii = thisWordWeight+72+(2*(25-thisWordWeight));
            char letter = (char)letterAscii;
            sb.append(letter);
        }
        return sb.toString();
    }
}