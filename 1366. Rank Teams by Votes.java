class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int[] ranks = map.getOrDefault(vote.charAt(i), new int[vote.length()]);
                ranks[i]++;
                map.put(vote.charAt(i), ranks);
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });
        for (Character c : map.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}
