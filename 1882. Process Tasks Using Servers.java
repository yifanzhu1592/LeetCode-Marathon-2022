class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] res = new int[tasks.length];
        PriorityQueue<int[]> freeServers = new PriorityQueue<int[]>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> assignedServers = new PriorityQueue<int[]>((a, b) -> a[2] != b[2] ? a[2] - b[2] : a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[] {i, servers[i]});
        }
        for (int i = 0; i < tasks.length; i++) {
            while (!assignedServers.isEmpty() && assignedServers.peek()[2] <= i) {
                int[] server = assignedServers.poll();
                freeServers.offer(new int[] {server[0], server[1]});
            }
            if (!freeServers.isEmpty()) {
                int[] server = freeServers.poll();
                res[i] = server[0];
                assignedServers.offer(new int[] {server[0], server[1], i + tasks[i]});
            } else {
                int[] server = assignedServers.poll();
                res[i] = server[0];
                assignedServers.offer(new int[] {server[0], server[1], server[2] + tasks[i]});
            }
        }
        return res;
    }
}
