class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for (int i = 0; i < capacity.length && additionalRocks >= 0; i++){
            if (additionalRocks >= capacity[i]) {
                count++;
            }
            additionalRocks -= capacity[i];    
        }        
        return count;        
    }
}
