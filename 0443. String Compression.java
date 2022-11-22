class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        while (i < chars.length) {
            char currentCharacter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currentCharacter) {
                i++;
                count++;
            }
            chars[j++] = currentCharacter;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}
