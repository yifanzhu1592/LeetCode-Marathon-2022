class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1, twoSum = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < twoSum) {
                    j++;
                } else if (nums[j] + nums[k] > twoSum) {
                    k--;
                } else {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}
