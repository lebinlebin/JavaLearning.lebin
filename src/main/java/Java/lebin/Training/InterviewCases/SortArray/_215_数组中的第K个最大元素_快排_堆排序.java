package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class _215_数组中的第K个最大元素_快排_堆排序 {
    /*
    方法二：基于堆排序的选择方法
    建立一个大根堆，做 k - 1 次删除操作后堆顶元素就是我们要找的答案。
     */
//    时间复杂度：O(nlogn)，建堆的时间代价是 O(n)，删除的总代价是 O(klogn)，因为k<n，故渐进时间复杂为 O(nlogn)。
//    空间复杂度：O(logn)，即递归使用栈空间的空间代价。
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        heapInsert(nums);
        //删除 k次，每次heapify时间为logn  因此复杂度为 klogn
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            heapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    //构造大根堆（通过新插入的数上升）
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前插入元素的索引
            int currentIndex = i;//0
            //父结点索引
            int fatherIndex = (currentIndex - 1) / 2;//第一步-1/2==0

            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                //交换当前结点与父结点的值
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }

        }
    }

    //将剩余的数构造成大根堆（通过顶端的数下降）
    public static void heapify(int[] arr, int index, int size) {
        //当前节点index是从最后节点交换过来的，通过堆的下率操作重新建堆
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }

            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }

            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }
    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
//------------------------------------------------------------
    /*
    方法一：基于快速排序的选择方法
    由此可以发现每次经过「划分」操作后，我们一定可以确定一个元素的最终位置，即 x 的最终位置为 q，
    并且保证 a[l,⋯,q−1] 中的每个元素小于等于 a[q]，且 a[q]小于等于a[q+1,⋯,r] 中的每个元素。
    所以只要某次划分的 q 为倒数第 k 个下标的时候，我们就已经找到了答案。
    我们只关心这一点，至于 a[l,⋯,q−1] 和 a[q+1,⋯,r] 是否是有序的，我们不关心。
     */
    //    时间复杂度：平均情况下为O(n)，最坏情况下为O(n^2)，但最坏情况发生的概率非常小。
    //这是因为我们每次都能排除掉一部分元素，所以平均情况下的时间复杂度为O(n)。
    //但如果我们每次选择的基准都是最大或最小的元素，那么我们就需要遍历所有的元素，所以最坏情况下的时间复杂度为O(n^2)。
    //    空间复杂度：O(1)，这是因为我们只需要常数级别的额外空间。
    public int findKthLargest (int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];
    }

    // 此处的 k 是按从小到大排的顺序
    // return the index of the kth smallest number
    private int quickSelect (int[] nums, int lo, int hi, int k) {
        int i = lo;
        int j = hi;
        int pivot = nums[hi];
        // < pivot 放左边
        // >= pivot 放右边
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi); // 将 pivot 放入正确位置

        // 计算 pivot 在数组中的位置
        int m = i - lo + 1;

        if (m == k) return i;
        else if (m > k) return quickSelect(nums, lo, i - 1, k);
        else return quickSelect(nums, i + 1, hi, k - m);
    }
}
