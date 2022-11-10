class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] sumRemain = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumRemain[i + 1] = ((sumRemain[i] + nums[i]) % k + k) % k;
        }
        int[] count = new int[k];
        for (int r : sumRemain) {
            count[r]++;
        }
        int res = 0;
        for (int c : count) {
            res += c * (c - 1) / 2;
        }
        return res;
    }
}
