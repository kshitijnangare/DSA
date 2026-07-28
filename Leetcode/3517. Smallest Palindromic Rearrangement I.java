class Solution {
    public String smallestPalindrome(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        int n = s.length();
        if(n==1){return s;}
        for(int i =0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            char c = e.getKey();
            int freq = e.getValue();
            if(freq == 1){
                sb2.append(c);
                continue;
            }
            if(freq%2==0){
                for(int i = 0; i<freq/2; i++){
                    sb1.append(c);
                }
            }else{
                freq=freq-1;
                    for(int i = 0; i<freq/2; i++){
                    sb1.append(c);
                }
                sb2.append(c);
            }
        }
        StringBuilder temp = new StringBuilder(sb1);
        temp.reverse();
        sb1.append(sb2);
        sb1.append(temp);
        return sb1.toString();

    }
}