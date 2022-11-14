class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftSmaller = 0, leftLarger = 0;
            int rightSmaller = 0, rightLarger = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftSmaller++;
                } else {
                    leftLarger++;
                }
            }
            for (int k = i + 1; k < rating.length; k++) {
                if (rating[k] < rating[i]) {
                    rightSmaller++;
                } else {
                    rightLarger++;
                }
            }
            count += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }
        return count;
    }
}
