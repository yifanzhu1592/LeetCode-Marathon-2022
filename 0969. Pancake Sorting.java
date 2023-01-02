class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int j;
            for (j = 0; arr[j] != i; j++) {}
            reverse(arr, j);
            list.add(j + 1);
            reverse(arr, i - 1);
            list.add(i);
        }
        return list;
    }

    private void reverse(int[] arr, int index) {
        for (int i = 0; i <= index / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[index - i];
            arr[index - i] = temp;
        }
    }
}
