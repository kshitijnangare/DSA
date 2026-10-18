// class Solution {
//     public int minSelection(int[][] availableIntervals, int[][] targetIntervals) {
//         Arrays.sort(availableIntervals, (a,b)-> {
//             if(a[0]==b[0]{
//                 return Integer.compare(a[1], b[1]);
//             }
//             return Integer.compare(a[0], b[0]);
//         });
//         Arrays.sort(targetIntervals, (a,b)-> {
//             if(a[1]==b[1]{
//                 return Integer.compare(a[0], b[0]);
//             }
//             return Integer.compare(a[1], b[1]);
//         });

//         int n = availableIntervals.length;
//         ArrayList<int[]> available = new ArrayList
//         /
//         for(int i = 1; i<n; i++){
//             if(int )
//         }
//     }
// }

class Solution {
    public int minSelection(int[][] availableIntervals, int[][] targetIntervals) {
        Arrays.sort(targetIntervals, (a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            else return b[1]-a[1];
        });
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<targetIntervals.length; i++){
            if(list.size() == 0 || targetIntervals[i][0] > list.get(list.size()-1)[1]){
                list.add(targetIntervals[i]);
            }
            else{
                int x[] = list.get(list.size()-1);
                x[1] = Math.max(x[1], targetIntervals[i][1]);
            }
        }

        Arrays.sort(availableIntervals, (a,b)->{
            return a[0]-b[0];
        });

        int i = 0;
        int j = 0;
        int curr = list.get(0)[0];
        int ans = 0;

        while(j < list.size()){
            int maxr = -1;
            while(i < availableIntervals.length && availableIntervals[i][0] <= curr){
                maxr = Math.max(maxr, availableIntervals[i][1]);
                i++;
            }

            if(maxr == -1) return -1;

            while(j < list.size() && list.get(j)[1] <= maxr){
                j++;
            }

            ans++;

            if(j == list.size()) return ans;

            curr = Math.max(maxr, list.get(j)[0]);
        }

        return ans;
    }
}