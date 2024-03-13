package Java.lebin.Training.InterviewCases.矩阵;
/*
8*8矩阵，元素由0和1组成，判断是否同一行或者同一列是否有相同的1
 */
public class 腾讯面试真题_矩阵去重 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        boolean hasDuplicates = checkForDuplicates(matrix);
        System.out.println("Matrix has duplicate 1s in the same row or column: " + hasDuplicates);
    }

    public static boolean checkForDuplicates(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check rows for duplicates
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
                if (count > 1) {
                    return true; // Duplicate found in this row
                }
            }
        }

        // Check columns for duplicates
        for (int j = 0; j < cols; j++) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
                if (count > 1) {
                    return true; // Duplicate found in this column
                }
            }
        }

        return false; // No duplicates found
    }
}