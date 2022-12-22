class Solution {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i) {
            tree.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        postOrderTraversal(0, -1);
        preOrderTraversal(0, -1);
        return res;
    }

    private void postOrderTraversal(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) {
                continue;
            }
            postOrderTraversal(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    private void preOrderTraversal(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) {
                continue;
            }
            res[i] = res[root] - count[i] + count.length - count[i];
            preOrderTraversal(i, root);
        }
    }
}
