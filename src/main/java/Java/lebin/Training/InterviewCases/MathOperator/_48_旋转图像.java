package Java.lebin.Training.InterviewCases.MathOperator;
/*
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
示例 1：
输入：
matrix =
[[1,2,3],
 [4,5,6],
 [7,8,9]]
输出：
[[7,4,1],
 [8,5,2],
 [9,6,3]]
 */
public class _48_旋转图像 {
    //方法一：使用辅助数组,暴力解法
    //时间复杂度：O(N^2)
    //空间复杂度：O(N^2)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }

    }
    //方法二：原地旋转
    //时间复杂度：O(N^2)
    //空间复杂度：O(1) 原地旋转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {//i < n / 2 沿着对角线走到矩阵中心的长度
            //每次交换涉及四个数字
            for (int j = i; j < n-1-i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
