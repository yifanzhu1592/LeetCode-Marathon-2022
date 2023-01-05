class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int arrowPosition = 0;
        int arrowCount = 0;
        for (int[] point : points) {
            if (arrowCount == 0 || arrowPosition < point[0]) {
                arrowCount++;
                arrowPosition = point[1];
            }
        }
        return arrowCount;
    }
}
