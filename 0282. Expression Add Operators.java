class Solution {
    List<String> paths = new ArrayList<>();
    String num;
    int target;
    
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        dfs(0, 0, 0, "");
        return paths;
    }

    private void dfs(int i, long prevVal, long prevNum, String path) {
        if (i == num.length()) {
            if (prevVal == target) {
                paths.add(path);
            }
            return;
        }
        for (int j = i; j < num.length(); j++) {
            if (j > i && num.charAt(i) == '0') {
                break;
            }
            long currentNum = Long.parseLong(num.substring(i, j + 1));
            if (i == 0) {
                dfs(j + 1, currentNum, currentNum, path + currentNum);
            } else {
                dfs(j + 1, prevVal + currentNum, currentNum, path + "+" + currentNum);
                dfs(j + 1, prevVal - currentNum, -currentNum, path + "-" + currentNum);
                dfs(j + 1, prevVal - prevNum + prevNum * currentNum, prevNum * currentNum, path + "*" + currentNum); 
            }
        }
    }
}
