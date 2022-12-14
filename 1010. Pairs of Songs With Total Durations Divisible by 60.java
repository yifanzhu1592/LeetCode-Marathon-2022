class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count[] = new int[60];
        int res = 0;
        for (int t : time) {
            res += count[(60 - t % 60) % 60];
            count[t % 60]++;
        }
        return res;
    }
}
