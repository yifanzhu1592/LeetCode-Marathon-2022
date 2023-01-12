class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int[] edge : edges) {
            adjacent.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            adjacent.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }
        int[] ans = new int[n];
        dfs(adjacent, 0, -1, labels, ans);
        return ans;
    }
    private int[] dfs(Map<Integer, List<Integer>> adjacent, int node, int parent, String labels, int[] ans) {
        int[] count = new int[26];
        char label = labels.charAt(node);
        for (int child : adjacent.getOrDefault(node, Collections.emptyList())) {
            if (child != parent) {
                int[] sub = dfs(adjacent, child, node, labels, ans);
                for (int i = 0; i < 26; ++i) {
                    count[i] += sub[i];
                }
            }
        }
        count[label - 'a']++;
        ans[node] = count[label - 'a'];
        return count;
    }
}
