class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] costs = new long[regular.length];
        long[] minCostReg = new long[regular.length + 1];
        long[] minCostExp = new long[express.length + 1];
        minCostReg[0] = 0;
        minCostExp[0] = expressCost;
        
        for (int i = 0; i < regular.length; i++) {
            costs[i] = Math.min(minCostReg[i] + regular[i], minCostExp[i] + express[i]);
            minCostReg[i + 1] = costs[i];
            minCostExp[i + 1] = Math.min(minCostReg[i + 1] + expressCost, minCostExp[i] + express[i]);
        }
        
        return costs;
    }
}
