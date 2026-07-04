class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1 = s.length();
        int n2= t.length();
        if(n1!=n2){return false;}
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();

        int i = 0;
        while(i<n1){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(maps.containsKey(c1)){
                char mapped = maps.get(c1);
                if(mapped!=c2){
                    return false;
                }
            }else{
                if(mapt.containsKey(c2)){
                    return false;
                }
            }
            
            maps.put(c1,c2);
            mapt.put(c2,c1);
            i++;
        }
        return true;
    }
}