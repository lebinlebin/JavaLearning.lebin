package Java.lebin.Training.InterviewCases.SortArray.乱序数组取k个数;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class _215_未排序数组第K个最大元素_快排_堆排序 {
    /*
    利用快排的思想，首先快排每次执行都能确定一个元素的最终的位置，如果这个位置是n-k(其中n是数组A的长度)的话，那么就相当于找到了第K大的元素。设确定的元素位置m的话，如果m > n - k大的话，那么第K大的数字一定
    在A[0]~A[m - 1]之间；如果m < n - k的话，那么第K大的数字一定在A[m+1]~A[n - 1]之间。
    如果要求第K小的数字的话，只需把n-k换成k-1即可(升序排序)。
     */
    /*
    时间复杂度分析。字节跳动面试题真题。
    结论:平均时间复杂度为O(N)，最坏情况下的时间复杂度为O(N^2)。
    1.我们要搞清楚一点，快排是对参考元素两边都进行递归，而我们的方法3只考虑参考元素的一边，即只对一边进行递归。
    2.我们可以粗略的估计下(具体计算还是参考《算导》)，在一般情况下方法3的时间复杂度计算公式，假设我们的数据足够的随机，每次划分都在数据序列的中间位置，
    那么第一次划分我们需要遍历约n个数，第二次需要遍历约n/2个数，...，这样递归下去，最后：
        n+n/2+n/2^2+n/2^3+,...,+n/2^m = n*(1+1/2+1/2^2+,...,1/2^m)
    当m趋于无穷大时，该式子收敛于2n，故可以认为其期望时间复杂度为O(N).

    空间复杂度：O(logn),递归使用栈空间的空间代价的期望为O(logn)。
     */
    public int findKthLargest (int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);//只要某次划分的 q 为倒数第 k 个下标的时候，就找到了答案。
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
        swap(nums, i, hi); // 将 pivot 放入正确位置，当前i就是本次确定的排序大小的index位置，第i-lo+1大元素标定好了

        // 计算 pivot 在数组中的位置
        int m = i - lo + 1;
        if (m == k){
            return i;//那么就是第k大元素
        } else if (m > k) {
            return quickSelect(nums, lo, i - 1, k);//还要继续寻找更小的，要在低分段区间查找
        } else {
            return quickSelect(nums, i + 1, hi, k - m);//m < k 还要继续找更大的，还要找k-m次，才能确定第k大元素
        }
    }
    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


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
}
