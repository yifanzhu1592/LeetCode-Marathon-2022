class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] map = new int[26];
        for (int i = 0; i < keyboard.length(); ++i) {
            map[keyboard.charAt(i) - 'a'] = i;
        }
        int cnt = 0;
        for (int i = 0, j = 0; j < word.length(); ++j) {
            cnt += Math.abs(map[word.charAt(j) - 'a'] - i);
            i = map[word.charAt(j) - 'a'];
        }
        return cnt;
    }
}
