class Solution {

    Map<Character, String> mapping = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> combinations;

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits.length() != 0) {
            backtrack("", digits, 0);
        }
        return combinations;
    }

    private void backtrack(String currentCombination, String digits, int currentDigit) {
        if (currentDigit == digits.length()) {
            combinations.add(currentCombination);
        } else {
            String letters = mapping.get(digits.charAt(currentDigit));
            for (Character letter : letters.toCharArray()) {
                backtrack(currentCombination + letter, digits, currentDigit + 1);
            }
        }
    }
}
