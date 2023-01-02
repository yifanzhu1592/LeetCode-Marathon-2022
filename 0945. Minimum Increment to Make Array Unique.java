class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i + 1] <= nums[i]) {
                sum += nums[i] - nums[i + 1] + 1;
                nums[i + 1] = nums[i] + 1;
            }
        }
        return sum;
    }
}
