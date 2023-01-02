class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDistance = 0;

        for (int[] nut : nuts) {
            totalDistance += (Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1])) * 2;
        }

        int minimalDistance = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            int nutTreeDistance = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
            int nutSquirrelDistance = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
            minimalDistance = Math.min(minimalDistance, totalDistance + nutSquirrelDistance - nutTreeDistance);
        }

        return minimalDistance;
    }
}
