class Solution {
    int transform(String s1, String s2) {
        // code here
        int n1= s1.length();
        int n2= s2.length();
        if(n1!=n2){
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<n1; i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }
        
        for(int i = 0; i<n1; i++){
            if(!map.containsKey(s2.charAt(i))){
                return -1;
            }else{
                int val = map.get(s2.charAt(i));
                val--;
                if(val<=0){
                    map.remove(s2.charAt(i));
                }else{
                    map.put(s2.charAt(i), val);
                }
            }
        }
        
        int i = n1-1;
        int j = n1-1;
        int count = 0;
        while(i>=0){
            if(s1.charAt(i)!=s2.charAt(j)){
                count++;
                i--;
            }else{
                i--;
                j--;
            }
        }
        return count;
        
    }
}