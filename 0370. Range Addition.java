class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], val = update[2];
            res[start] += val;
            if (end + 1 < res.length) {
                res[end + 1] -= val;
            }
        }
        int curSum = 0;
        for (int i = 0; i < length; i++) {
            curSum += res[i];
            res[i] = curSum;
        }
        return res;
    }
}
