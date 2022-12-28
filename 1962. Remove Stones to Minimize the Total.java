class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int pile : piles) {
            pq.offer(pile);
            res += pile;
        }
        while (k-- > 0) {
            int pile = pq.poll();
            pq.offer(pile - pile / 2);
            res -= pile / 2;
        }
        return res;
    }
}
