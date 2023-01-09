class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        return root >= 0 && bfs(n, root, leftChild, rightChild);
    }

    private int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            seen.add(i);
        }
        for (int[] children : new int[][]{leftChild, rightChild}) {
            for (int child : children) {
                if (child >= 0 && !seen.remove(child)) {
                    return -1;
                }
            }
        }
        return seen.size() == 1 ? seen.iterator().next() : -1;
    }

    private boolean bfs(int n, int root, int[] leftChild, int[] rightChild) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        Set<Integer> seen = new HashSet<>(queue);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : new int[]{leftChild[node], rightChild[node]}) {
                if (child >= 0) {
                    seen.add(child);
                    queue.offer(child);
                }
            }
        }
        return seen.size() == n;
    }
}
