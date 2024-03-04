package Java.lebin.Training.InterviewCases.各种k个数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 剑指 Offer 40. 最小的k个数
 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 示例 1：
 输入：arr = [3,2,1], k = 2
 输出：[1,2] 或者 [2,1]
 */
public class _40_最小的k个数 {
    //基础版本
    /*
    复杂度分析
    时间复杂度：O(nlogn)，其中 n 是数组 arr 的长度。算法的时间复杂度即排序的时间复杂度。
    空间复杂度：O(logn)，排序所需额外的空间复杂度为 O(logn)。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }


    /*
    方法二：堆
    思路和算法
    用一个大根堆实时维护数组的前 k 小值。首先将前 k 个数插入大根堆中，随后从第 k+1 个数开始遍历，
    如果当前遍历到的数比大根堆的堆顶的数要小，就把堆顶的数弹出，再插入当前遍历到的数。
    最后将大根堆里的数存入数组返回即可。
    复杂度分析
    时间复杂度：O(nlogk)。由于大根堆实时维护前 k 小值，所以插入删除都是 O(logk) 的时间复杂度，
    最坏情况下数组里 n 个数都会插入，所以一共需要 O(nlogk) 的时间复杂度。
    空间复杂度：O(k)，因为大根堆里最多 k 个数。
     */

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }

    /*
    方法三：快排思想
    思路和算法
    我们可以借鉴快速排序的思想。我们知道快排的划分函数每次执行完后都能将数组分成两个部分，小于等于分界值 pivot 的元素的都会被放到数组的左边，
    大于的都会被放到数组的右边，然后返回分界值的下标。与快速排序不同的是，快速排序会根据分界值的下标递归处理划分的两侧，而这里我们只处理划分的一边。
    我们定义函数 randomized_selected(arr, l, r, k) 表示划分数组 arr 的 [l,r] 部分，使前 k 小的数在数组的左侧，
    在函数里我们调用快排的划分函数，假设划分函数返回的下标是 pos（表示分界值 pivot 最终在数组中的位置），
    即 pivot 是数组中第 pos - l + 1 小的数，那么一共会有三种情况：
    如果 pos - l + 1 == k，表示 pivot 就是第 kk 小的数，直接返回即可；
    如果 pos - l + 1 < k，表示第 kk 小的数在 pivot 的右侧，因此递归调用 randomized_selected(arr, pos + 1, r, k - (pos - l + 1))；
    如果 pos - l + 1 > k，表示第 kk 小的数在 pivot 的左侧，递归调用 randomized_selected(arr, l, pos - 1, k)。
    函数递归入口为 randomized_selected(arr, 0, arr.length - 1, k)。在函数返回后，将前 k 个数放入答案数组返回即可。

    复杂度分析

    时间复杂度：期望为 O(n)O(n) ，由于证明过程很繁琐，所以不再这里展开讲。具体证明可以参考《算法导论》第 9 章第 2 小节。

    最坏情况下的时间复杂度为 O(n^2)。情况最差时，每次的划分点都是最大值或最小值，一共需要划分n−1 次，
    而一次划分需要线性的时间复杂度，所以最坏情况下时间复杂度为 O(n^2)。
    空间复杂度：期望为O(logn)，递归调用的期望深度为 O(logn)，每层需要的空间为 O(1)，只有常数个变量。
    最坏情况下的空间复杂度为 O(n)。最坏情况下需要划分 n 次，即 randomized_selected 函数递归调用最深n−1 层，
    而每层由于需要 O(1) 的空间，所以一共需要 O(n) 的空间复杂度。
     */

    public int[] getLeastNumbers3(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
