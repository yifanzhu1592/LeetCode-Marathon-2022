class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + s.charAt(index) - '0';
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resultStack.push(sb.toString());
                sb.setLength(0);
                index++;
            } else if (s.charAt(index) == ']') {
                int count = countStack.pop();
                String currentString = sb.toString();
                for (int i = 0; i < count - 1; i++) {
                    sb.append(currentString);
                }
                String previousString = resultStack.pop();
                sb.insert(0, previousString);
                index++;
            } else {
                sb.append(s.charAt(index));
                index++;
            }
        }

        return sb.toString();
    }
}
