class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                String curr = q.poll();
                if(endWord.equals(curr)){
                    return len+1;
                }
                char[] chararr = curr.toCharArray();
                for(int j = 0; j<chararr.length; j++){
                    char ogchar = chararr[j];
                    for(char c = 'a'; c<='z'; c++){
                        chararr[j]=c;
                        String s = new String(chararr);
                        if(set.contains(s)){
                            q.add(s);
                            set.remove(s);
                        }
                    }
                    chararr[j]=ogchar;
                }
            }
            len++;
        }
        return 0;

    }
}