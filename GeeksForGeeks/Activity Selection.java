class Activity{
    int start;
    int finish;
    Activity(int s, int f){
        this.start = s;
        this.finish = f;
    }
}

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        Activity[] list = new Activity[start.length];
        for(int i = 0; i<start.length; i++){
            list[i] = new Activity(start[i], finish[i]);
        }
        
        Arrays.sort(list, (a,b) -> Integer.compare(a.finish, b.finish));
        
        int res = 1;
        Activity prev = list[0];
        for(int i = 1; i<start.length; i++){
            Activity curr = list[i];
            if(curr.start > prev.finish){
                res++;
                prev = curr;
            }
        }
        return res;
    }
}