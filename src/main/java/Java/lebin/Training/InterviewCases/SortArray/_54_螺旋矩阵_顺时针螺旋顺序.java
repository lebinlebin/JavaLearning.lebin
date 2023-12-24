package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class _54_螺旋矩阵_顺时针螺旋顺序 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;


        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // left top -> right top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // right top -> right bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 奇数行、偶数列的时候有问题
            if (top > bottom || left > right) break;

            // right bottom -> left bottom
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            // left bottom -> left top
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }


    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new int[0];
        int col_begin = 0, col_end = matrix[0].length - 1, row_begin = 0, row_end = matrix.length - 1;
//        int l = 0, r = array[0].length - 1, t = 0, b = array.length - 1, x = 0;
        int[] res = new int[(col_end + 1) * (row_end + 1)];
        int x = 0;
        while(true) {
            for(int i = col_begin; i <= col_end; i++) res[x++] = matrix[row_begin][i]; // left to right
            if(++row_begin > row_end) break;
            for(int i = row_begin; i <= row_end; i++) res[x++] = matrix[i][col_end]; // top to bottom
            if(col_begin > --col_end) break;
            for(int i = col_end; i >= col_begin; i--) res[x++] = matrix[row_end][i]; // right to left
            if(row_begin > --row_end) break;
            for(int i = row_end; i >= row_begin; i--) res[x++] = matrix[i][col_begin]; // bottom to top
            if(++col_begin > col_end) break;
        }
        return res;
    }
}
