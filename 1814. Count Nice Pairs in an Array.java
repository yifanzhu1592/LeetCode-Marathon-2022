class Solution {
    public int countNicePairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num - reverse(num))) {
                count = (count + map.get(num - reverse(num))) % ((int) 1e9 + 7);
                
            }
            map.put(num - reverse(num), map.getOrDefault(num - reverse(num), 0) + 1);
        }
        return count;
    }

    private int reverse(int num) {
        int reversedNum = 0;
        while (num > 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num /= 10;
        }
        return reversedNum;
    }
}
