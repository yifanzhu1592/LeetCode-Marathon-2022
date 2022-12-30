class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int[] numWays = new int[s.length() + 1];
        numWays[0] = 1;
        numWays[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            int previous = s.charAt(i - 1) - '0';
            int current = s.charAt(i) - '0';
            if ((previous == 0 && current == 0) || (current == 0 && (previous * 10 + current > 26))) {
                return 0;
            } else if (previous == 0 || previous * 10 + current > 26) {
                numWays[i + 1] = numWays[i];
            } else if (current == 0) {
                numWays[i + 1] = numWays[i - 1];
            } else {
                numWays[i + 1] = numWays[i - 1] + numWays[i];
            }
        }

        return numWays[s.length()];
    }
}
