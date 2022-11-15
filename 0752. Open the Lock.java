class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (target.equals(s)) {
                    return steps;
                }
                if (visited.contains(s) || deadendsSet.contains(s)) {
                    continue;
                }
                visited.add(s);
                for (int j = 0; j < s.length(); j++) {
                    String lower = s.substring(0, j) + (s.charAt(j) == '0' ? "9" : s.charAt(j) - '0' - 1) + s.substring(j + 1);
                    String higher = s.substring(0, j) + (s.charAt(j) == '9' ? "0" : s.charAt(j) - '0' + 1) + s.substring(j + 1);
                    queue.offer(lower);
                    queue.offer(higher);
                }
            }
            steps++;
        }
        
        return -1;
    }
}
