class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<String>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + " " + obstacle[1]);
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0;
        int y = 0;
        int maxEuclideanDistance = 0;
        for (int command : commands) {
            if (command == -2) {
                direction--;
                if (direction == -1) {
                    direction = 3;
                }
            } else if (command == -1) {
                direction++;
                if (direction == 4) {
                    direction = 0;
                }
            } else {
                while (command-- > 0 && !obs.contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))) {
                  x += directions[direction][0];
                  y += directions[direction][1];
                }
                maxEuclideanDistance = Math.max(maxEuclideanDistance, x * x + y * y);
            }
        }
        return maxEuclideanDistance;
    }
}
