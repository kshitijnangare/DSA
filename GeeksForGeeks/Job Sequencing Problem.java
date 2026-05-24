/*
struct Job
{
   int id;	 // Job Id
   int deadline; // Deadline of job
   int profit; // Profit if job is over before or on deadline
};
*/
class Solution {
    int[] JobScheduling(Job arr[], int n) {
        // code here
        Arrays.sort(arr, (a,b)->{
            if(a.profit!=b.profit){
                return Integer.compare(b.profit,a.profit);
            }
            return Integer.compare(b.deadline, a.deadline);
        });
        
        int maxDeadline = 0;
        for(int i = 0; i<n; i++){
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        
        int noOfJobs = 0;
        int maxProf = 0;
        boolean[] filled = new boolean[maxDeadline+1];
        for(int i = 0; i<n; i++){
            int prof = arr[i].profit;
            int deadline = arr[i].deadline;
            while(deadline>0){
                if(filled[deadline]==false){
                    filled[deadline]=true;
                    maxProf = maxProf+prof;
                    noOfJobs++;
                    break;
                }
                deadline--;
            }
        }
        
        return new int[]{noOfJobs, maxProf};
        
        
    }
}