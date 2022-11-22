class Solution {
    public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE, secondMax= Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE, min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
            
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }
        
        return Math.max(max * secondMax * thirdMax, max * min * secondMin);
    }
}
