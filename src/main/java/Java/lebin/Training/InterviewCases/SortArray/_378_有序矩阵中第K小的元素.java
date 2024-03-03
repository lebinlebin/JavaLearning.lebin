package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
public class _378_有序矩阵中第K小的元素 {
    //最直接的做法是将这个二维数组转成一维数组，并对该一维数组进行排序。最后这个一维数组中的第 k 个数即为答案。
    //时间复杂度：O(n^2*log{n})，对 n^2个数排序。
    //空间复杂度：O(n^2)，一维数组需要存储这n^2个数。
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
    /*
    时间复杂度：O(klogn)，归并 k 次，每次堆中插入和弹出的操作时间复杂度均为 logn。
    空间复杂度：O(n)，堆的大小始终为 n。
    需要注意的是，k 在最坏情况下是 n^2，因此该解法最坏时间复杂度为 O(n^2*log{n})
     */
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    //二分查找
    /*
    矩阵内的元素是从左上到右下递增的
    二维数组中 matrix[0][0] 为最小值，matrix[n−1][n−1]为最大值，现在我们将其分别记作 l 和 r。
     */
    //时间复杂度：O(nlog(r−l))，二分查找进行次数为 O(log(r−l))，每次操作时间复杂度为 O(n)。
    //空间复杂度：O(1)。
    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
    /*
    上述三种解法，
    第一种没有利用矩阵的性质，所以时间复杂度最差；
    第二种解法只利用了一部分性质（每一行是一个有序数列，而忽视了列之间的关系）；
    第三种解法则利用了全部性质，所以时间复杂度最佳。
     */

}
