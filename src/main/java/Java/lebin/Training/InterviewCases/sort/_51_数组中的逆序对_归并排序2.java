package Java.lebin.Training.InterviewCases.sort;

/**
 剑指 Offer 51. 数组中的逆序对
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 输入一个数组，求出这个数组中的逆序对的总数。
 示例 1:
 输入: [7,5,6,4]
 输出: 5
 */
/*
想法的由来：
顺序数组的逆序对总数为 0，倒序数组的逆序对总数达到最大，因此 掌握数组的有序性 可以 一下子 数出逆序对的总数；
分而治之，一边计算逆序对的总数，一边排序。所有的「逆序对」来源于 3 个部分：
    左边区间的逆序对；
    右边区间的逆序对；
    横跨两个区间的逆序对。
排序的作用：
    排序以后消除逆序对，避免重复计算；
    当前排序，为下一轮排序、为下一轮一下子数出逆序对的总数做好了基础。
由于「逆序」这件事情是对称的，可以数出：
    后面有多少个元素比自己小；
    前面有多少个元素比自己大。
因此有两种方法可以数出逆序对的总数。
 */
public class _51_数组中的逆序对_归并排序2 {
    //归并计数法。分治算法
    //O(nlogn)就是归并排序的时间复杂度
    //空间复杂度O(n)
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            // 有下标访问，得先判断是否越界
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里是 <= ，写成 < 就不对，请思考原因
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;

                // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
