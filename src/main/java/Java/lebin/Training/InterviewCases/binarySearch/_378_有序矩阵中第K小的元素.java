package Java.lebin.Training.InterviewCases.binarySearch;
/*
给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
你必须找到一个内存复杂度优于 O(n2) 的解决方案。

示例 1：
输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
输出：13
解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
示例 2：
输入：matrix = [[-5]], k = 1
输出：-5

 */
/*
如果要找一个 有确定范围 的 整数，可以考虑使用二分查找算法。
二分查找先猜一个数 a ，然后遍历整个矩阵：
如果小于等于 a 的元素的个数严格小于（<）k 个，说明猜的这个数太小了，正确的答案比 a 大；
如果小于等于 a 的元素的个数恰好等于（=）k 个，说明猜的这个数有可能是正确的答案，但是也有可能不是。如果不是，正确答案只可能比 a 小，但是一定不会比 a 大（这一点大家可以举例说明，我们放在题解的最后说）；
如果小于等于 a 的元素的个数严格大于（>）k 个，说明猜的这个数太大了，正确的答案比 a 小。
事实上「遍历」整个数组没有利用到题目中给出的「每行和每列元素均按升序排序」这个条件，根据「力扣」 240. 搜索二维矩阵 II 的经验，
我们可以 从矩阵的「左下角」或者「右上角」开始遍历，以线性的时间复杂度计算出矩阵中小于等于某个数的元素的个数。
 */
/*
时间复杂度：O((matrix[n−1][n−1]−matrix[0][0])logn)
这里 matrix[n−1][n−1]−matrix[0][0] 表示二分查找需要猜测的数的范围，每一次猜测需要「看一下矩阵」，「看一下矩阵」的时间复杂度为 O(n)。
 */
public class _378_有序矩阵中第K小的元素 {
    //参考代码 1：从矩阵的右下角开始找
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = lessEquals(matrix, mid);
            if (count < k) {
                // 下一轮搜索区间在 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间在 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 计算小于等于 target 的元素的个数，
     * 从矩阵的右下角开始找
     */
    private int lessEquals(int[][] matrix, int target) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                count += i + 1;//i是从0开始的这里要加实际的值，所以 +（i+1）
                j++;
            } else {
                i--;
            }
        }
        return count;
    }



    //参考代码 2：从矩阵的左上角开始找
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = lessEquals2(matrix, mid);
            if (count < k) {
                // 下一轮搜索区间在 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间在 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 计算小于等于 target 的元素的个数，从矩阵的左上角开始找
     *
     * @param matrix
     * @param target
     * @return
     */
    private int lessEquals2(int[][] matrix, int target) {
        int n = matrix.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n && j >= 0) {
            if (matrix[i][j] <= target) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
