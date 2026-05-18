class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
        
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size(); 
            
            for (int i = 0; i < levelSize; i++) {
                int currInd = q.poll();

                if (currInd == n - 1) {
                    return steps;
                }
                if (currInd + 1 < n && visited[currInd + 1] == false) {
                    visited[currInd + 1] = true;
                    q.add(currInd + 1);
                }
                if (currInd - 1 >= 0 && visited[currInd - 1] == false) {
                    visited[currInd - 1] = true;
                    q.add(currInd - 1);
                }
                int currVal = arr[currInd];
                if (map.containsKey(currVal)) {
                    ArrayList<Integer> matchingIndices = map.get(currVal);
                    
                    for (int nextIdx : matchingIndices) {
                        if (visited[nextIdx] == false) {
                            visited[nextIdx] = true;
                            q.add(nextIdx);
                        }
                    }
                    map.remove(currVal);
                }
            }
            steps++; 
        }

        return -1;
    }
}