class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtracking(graph, allPaths, path, 0);
        return allPaths;
    }

    private void backtracking(int[][] graph, List<List<Integer>> allPaths, List<Integer> path, int currentNode) {
        if (currentNode == graph.length - 1) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for (int nextNode : graph[currentNode]) {
                path.add(nextNode);
                backtracking(graph, allPaths, path, nextNode);
                path.remove(path.size() - 1);
            }
        }
    }
}
