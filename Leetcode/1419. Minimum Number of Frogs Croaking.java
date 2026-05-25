class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int frogs = 0;
        int minFrogs = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<croakOfFrogs.length(); i++){
            char c = croakOfFrogs.charAt(i);
            int cFreq=0,rFreq=0,oFreq=0,aFreq=0,kFreq=0;
            switch(c){
                case 'c':
                    frogs++;
                    minFrogs = Math.max(minFrogs, frogs);
                    map.put(c, map.getOrDefault(c, 0)+1);
                    break;
                case 'r':
                    cFreq = map.getOrDefault('c',0);
                    rFreq = map.getOrDefault('r',0);
                    if(cFreq<=rFreq){
                        return -1;
                    }
                    map.put(c, map.getOrDefault(c, 0)+1);
                    break;
                case 'o':
                    rFreq = map.getOrDefault('r',0);
                    oFreq = map.getOrDefault('o',0);
                    if(rFreq<=oFreq){
                        return -1;
                    }
                    map.put(c, map.getOrDefault(c, 0)+1);
                    break;
                case 'a':
                    oFreq = map.getOrDefault('o',0);
                    aFreq = map.getOrDefault('a',0);
                    if(oFreq<=aFreq){
                        return -1;
                    }
                    map.put(c, map.getOrDefault(c, 0)+1);
                    break;
                case 'k':
                    aFreq = map.getOrDefault('a',0);
                    kFreq = map.getOrDefault('k',0);
                    if(aFreq<=kFreq){
                        return -1;
                    }
                    map.put(c, map.getOrDefault(c, 0)+1);
                    frogs--;
                    break;
                default:
                    return -1;
                
            }
        }
        int freq = map.getOrDefault('c',0);
        for(int val: map.values()){
            if(val!=freq){
                return -1;
            }
        }
        return minFrogs;
    }
}