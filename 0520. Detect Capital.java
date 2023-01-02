class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.length() == 1 || word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }

        return false;
    }
}
