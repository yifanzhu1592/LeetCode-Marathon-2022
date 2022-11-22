class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            List<Integer> prevList = list.get(list.size() - 1);
            for (int j = 0; j < prevList.size() - 1; j ++) {
                subList.add(prevList.get(j) + prevList.get(j + 1));
            }
            subList.add(1);
            list.add(subList);
        }
        
        return list;
    }
}
