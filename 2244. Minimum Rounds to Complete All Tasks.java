class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        int minimumRounds = 0;
        for (int count : frequency.values()) {
            if (count == 1) {
                return - 1;
            }

            if (count % 3 == 0) {
                minimumRounds += count / 3;
            } else {
                minimumRounds += count / 3 + 1;
            }
        }

        return minimumRounds;
    }
}
