class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.isEmpty() && i - list.peekFirst() >= k) {
                list.pollFirst();
            }
            while (!list.isEmpty() && nums[i] > nums[list.peekLast()]) {
                list.pollLast();
            }
            list.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
