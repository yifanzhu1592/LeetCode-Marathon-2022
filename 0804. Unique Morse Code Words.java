class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mapping = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(mapping[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
