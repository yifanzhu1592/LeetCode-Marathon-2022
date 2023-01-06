class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = costs[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
            map.put(cost, map.getOrDefault(cost, 0) + 1);
        }
        int count = 0;
        for (int cost = 1; cost <= maxCost; cost++) {
            int num = map.getOrDefault(cost, 0);
            while (num > 0 && coins - cost >= 0) {
                coins -= cost;
                num--;
                count++;
            }
            if (coins - cost < 0) {
                return count;
            }
        }
        return count;
    }
}
