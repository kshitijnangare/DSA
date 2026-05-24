class Task{
    int et;
    int pt;
    int in;
    Task(int e, int p, int i){
        this.et = e;
        this.pt = p;
        this.in = i;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];

        Task[] sortedTasks = new Task[n];
        for (int i = 0; i < n; i++) {
            sortedTasks[i] = new Task(tasks[i][0], tasks[i][1], i);
        }
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a.et, b.et));
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.pt != b.pt) {
                return Integer.compare(a.pt, b.pt);
            }
            return Integer.compare(a.in, b.in);
        });
        long timer = 0;
        int taskIdx = 0;
        int resIdx = 0;
        while (resIdx < n) {
            if (pq.isEmpty() && timer < sortedTasks[taskIdx].et) {
                timer = sortedTasks[taskIdx].et;
            }
            while (taskIdx < n && sortedTasks[taskIdx].et <= timer) {
                pq.add(sortedTasks[taskIdx]);
                taskIdx++;
            }
            Task curr = pq.poll();
            res[resIdx++] = curr.in;
            timer += curr.pt;
        }
        return res;
    }
}