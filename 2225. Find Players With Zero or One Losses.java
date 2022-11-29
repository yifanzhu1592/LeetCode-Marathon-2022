class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[][] count = new int[100001][2];

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            count[winner][0] += 1;
            count[loser][1] += 1;
        }

        List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 100001; ++i) {
            if (count[i][1] == 0 && count[i][0] != 0) {
                answer.get(0).add(i);
            } else if (count[i][1] == 1) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }
}
