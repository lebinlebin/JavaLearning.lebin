package Java.lebin.Training.InterviewCases.各种k个数;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 */
public class _4_寻找两个正序数组的中位数_两个升序数组第k小的数 {
    /*
    解法一中，我们一次遍历就相当于去掉不可能是中位数的一个值，也就是一个一个排除。
    由于数列是有序的，其实可以一半儿一半儿的排除。假设要找第 k 小数，
    可以每次循环排除掉 k/2 个数。
    要找到第 k (k>1) 小的元素
     */
    //时间复杂度：O(log(m+n))
    //空间复杂度：O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {//奇数
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);//midIndex是从0下标开始的，比如[1，2，,3] 是求第2小的数，这个2是midIndex+1来的
            return median;
        } else {//偶数
            int midIndex1 = totalLength / 2 - 1;//-1就是左边那个数
            int midIndex2 = totalLength / 2;//整除就是右边的那个数
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较。 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 每次排除k/2-1个元素
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        //循环排除法
        while (true) {
            // 边界情况 第一个数组大小为0
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            //第二个数组大小为0
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }

            //第(K=1)一小的元素，就是两个数组取出一个来最小的
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {//pivot取最小的那个
                k -= (newIndex1 - index1 + 1);//变化k值，变化index1的值，排除掉k/2-1个元素
                index1 = newIndex1 + 1;//删掉
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;//删掉
            }
        }

    }

    //--------------------------------------------------------------------------------------------------------------------------------
    /*
思路: 不进行A数组和B数组的合并，而是直接遍历两个数组，每次拿到小的那个数，一直取到len/2个数，就是中位数，中间需要判定 A+B数组是奇数还是偶数。
用 aStart 和 bStart 分别表示当前指向 A 数组和 B 数组的位置。
如果 aStart 还没有到最后并且此时 A 位置的数字小于 B 位置的数字，那么就可以后移了。
也就是 aStart＜alen && A[aStart]< B[bStart]。
如果 B 数组此刻已经没有数字了，继续取数字 B[ bStart ]，则会越界，所以判断下 bStart 是否大于数组长度了，
这样 || 后边的就不会执行了，也就不会导致错误了，所以增加为 aStart＜alen && (bStart >= blen || A[aStart] < B[bStart] ) 。
*/

    //时间复杂度：O(m+n)。遍历 len/2+1 次，len=m+n
//空间复杂度是 O(1）
    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;
        int totallen = alen + blen;
        int left = -1;
        int right = -1;
        int aStart = 0;
        int bStart = 0;

        //  len/2  中间位置
        for (int i = 0; i <= totallen / 2; i++) {
            left = right;
            //                      作为一个flag,当为true就不进行 ||后边的判断
            if ( aStart < alen && (bStart >= blen || A[aStart] < B[bStart] ) ) {
                right = A[aStart];//A数组小的值记录下来
                aStart ++;
            } else {
                right = B[bStart];//B数组小的值记录下来
                bStart ++ ;
            }
        }

        if ((totallen & 1) == 0)//偶数的情况
            return (left + right) / 2.0;
        else
            //奇数的情况
            return right;
    }

    public static void main(String[] args) {
        //nums1 = [1,3], nums2 = [2]
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}