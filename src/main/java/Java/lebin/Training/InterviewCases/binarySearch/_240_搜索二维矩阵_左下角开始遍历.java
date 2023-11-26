package Java.lebin.Training.InterviewCases.binarySearch;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 算法：
 * 首先，我们初始化一个指向矩阵左下角的 (row，col)指针。然后，
 * 直到找到目标并返回 true（或者指针指向矩阵维度之外的 (row，col) 为止，
 *
 * 我们执行以下操作：如果当前指向的值大于目标值，则可以 “向上” 移动一行。
 * 否则，如果当前指向的值小于目标值，则可以移动一列。
 *
 * 不难理解为什么这样做永远不会删减正确的答案；
 * 因为行是从左到右排序的，所以我们知道当前值右侧的每个值都较大。
 * 因此，如果当前值已经大于目标值，我们知道它右边的每个值会比较大。
 * 也可以对列进行非常类似的论证，
 * 因此这种搜索方式将始终在矩阵中找到目标（如果存在）。
 *
 */
public class _240_搜索二维矩阵_左下角开始遍历 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length-1;
		int col = 0;

		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] > target) {
				row--;
			} else if (matrix[row][col] < target) {
				col++;
			} else { // found it
				return true;
			}
		}

		return false;
	}
}


