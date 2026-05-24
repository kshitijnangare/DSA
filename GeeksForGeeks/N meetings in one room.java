class Meeting{
    int start;
    int end;
    Meeting(int s, int e){
        start = s;
        end = e;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        Meeting[] arr = new Meeting[start.length];
        for(int i = 0; i<start.length; i++){
            arr[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(arr, (a,b)->Integer.compare(a.end,b.end));
        int count = 1;
        Meeting prev = arr[0]; 
        for(int i = 1; i<start.length; i++){
            if(arr[i].start>prev.end){
                prev = arr[i];
                count++;
            }
        }
        return count;
    }
}
