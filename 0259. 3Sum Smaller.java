class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }
    
    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int i = startIndex;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                sum += j - i;
                i++;
            } else {
                j--;
            }
        }
        return sum;
    }
}
