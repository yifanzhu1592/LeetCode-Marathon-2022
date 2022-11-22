class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int currentCol = colStart; currentCol <= colEnd; currentCol++) {
                list.add(matrix[rowStart][currentCol]);
            }
            rowStart++;
            
            for (int currentRow = rowStart; currentRow <= rowEnd; currentRow++) {
                list.add(matrix[currentRow][colEnd]);
            }
            colEnd--;
            
            if (rowStart <= rowEnd && colStart <= colEnd) {
                for (int currentCol = colEnd; currentCol >= colStart; currentCol--) {
                    list.add(matrix[rowEnd][currentCol]);
                }
                rowEnd--;
                for (int currentRow = rowEnd; currentRow >= rowStart; currentRow--) {
                    list.add(matrix[currentRow][colStart]);
                }
                colStart++;
            }
            
        }
        
        return list;
    }
}
