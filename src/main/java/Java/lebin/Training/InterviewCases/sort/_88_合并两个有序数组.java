package Java.lebin.Training.InterviewCases.sort;
/*
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意： 最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。

 */
public class _88_合并两个有序数组 {
    //方法一：从头到尾归并（习惯上会先这样做）
    //时间复杂度：O(M+N)，这里M 是数组 nums1 的长度，N 是数组 nums2 的长度。
    //空间复杂度：O(M)，这里 M 是 nums1 的长度。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        // 只需要把 nums1 的有效个元素复制到 nums3 就可以了
        System.arraycopy(nums1, 0, nums3, 0, m);
        // 数组3
        int i = 0;
        // 数组2
        int j = 0;
        int length = m + n;
        // 从前向后归并，比较 nums3 和 nums2 前端的元素哪个小，谁小谁出列，覆盖 nums1
        for (int k = 0; k < length; k++) {
            // 注意：要把 nums3 和 nums2 归并完成的逻辑写在前面，否则会出现数组下标越界异常
            if (i == m) {
                nums1[k] = nums2[j];
                j++;
            } else if (j == n) {
                nums1[k] = nums3[i];
                i++;
            } else if (nums3[i] < nums2[j]) {
                nums1[k] = nums3[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

    /*
    方法二：从尾到头归并（符合题目要求，并且可以提前终止归并）
    注意 1：从后向前归并，先写数组下标用完的逻辑，否则会出现数组下标异常；
    注意 2：当 nums2 数组所有的数都看完的时候，算法终止。
     */
    //时间复杂度：O(M+N)，这里 M 是数组 nums1 的长度，N 是数组 nums2 的长度。
    //空间复杂度：O(1)，该算法没有使用额外的存储空间，仅使用了常数个临时变量用于比较。
    public void merge_(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int i = m - 1;
        int j = n - 1;
        // 从后向前归并，比较 nums1 和 nums2 末尾的元素哪个大，谁大谁出列，覆盖 nums1
        for (int k = len - 1; k >= 0; k--) {
            if (i == -1) {
                // 注意：同样要把 nums1 和 nums2 归并完成的逻辑写在前面，否则会出现数组下标越界异常
                // 此时 j 位于数组 nums2 的末尾索引位置，还未看的数组 nums2 的长度为 j + 1
                // 复制完 break 掉即可
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
                break;
            } else if (j == -1) {
                // 注意：这里直接 break 掉就可以了
                // 因为 nums2 遍历完成以后，nums1 剩下的元素虽然还没有看，但一定是排定以后的那个样子
                break;
            } else if (nums1[i] >= nums2[j]) {
                // 谁大谁出列
                nums1[k] = nums1[i];
                i--;
            } else {
                assert nums1[i] < nums2[j];
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

}
