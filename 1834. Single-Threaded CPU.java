class Solution {
    public int[] getOrder(int[][] tasks) {        
        int sortedTasks[][] = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, (taskA, taskB) -> taskA[0] - taskB[0]);

        PriorityQueue<int[]> availableTasks = new PriorityQueue<int[]>((taskA, taskB) -> (taskA[1] != taskB[1] ? (taskA[1] - taskB[1]) : (taskA[2] - taskB[2])));
        List<Integer> processedTasks = new ArrayList<>();
        long currentTime = 0;
        int taskIndex = 0;
        
        while (taskIndex < tasks.length || !availableTasks.isEmpty()) {
            if (availableTasks.isEmpty() && currentTime < sortedTasks[taskIndex][0]) {
                currentTime = sortedTasks[taskIndex][0];
            }
            
            while (taskIndex < tasks.length && currentTime >= sortedTasks[taskIndex][0]) { 
                availableTasks.add(sortedTasks[taskIndex]);
                taskIndex++;
            }
            
            currentTime += availableTasks.peek()[1];
            processedTasks.add(availableTasks.peek()[2]);
            availableTasks.poll();
        }
        
        return processedTasks.stream().mapToInt(i -> i).toArray();
    }
}
