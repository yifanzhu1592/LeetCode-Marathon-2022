class Solution {
    public String multiply(String num1, String num2) {
        int[] product = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digitProduct = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[i + j + 1] += digitProduct % 10;
                if (product[i + j + 1] >= 10) {
                    product[i + j + 1] -= 10;
                    product[i + j]++;
                }
                product[i + j] += digitProduct / 10;
                if (product[i + j] >= 10) {
                    product[i + j] -= 10;
                    product[i + j - 1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : product) {
            sb.append(digit);
        }
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}
