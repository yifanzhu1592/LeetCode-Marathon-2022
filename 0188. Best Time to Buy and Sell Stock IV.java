class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            int sum = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    sum += prices[i + 1] - prices[i];
                }
            }
            return sum;
        }
        
        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}
