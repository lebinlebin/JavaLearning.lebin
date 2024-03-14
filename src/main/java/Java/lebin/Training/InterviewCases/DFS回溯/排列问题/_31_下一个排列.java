package Java.lebin.Training.InterviewCases.DFS回溯.排列问题;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 */
public class _31_下一个排列 {
    /*
    思路整理: 从后往前保持降序，遇到的第一个破坏降序的数字，记录其下标i
    从i+1,向后找到第一个比i位置数字大的后续数字j
    将i数字和j数字swap
    将i+1,n 一定是一个降序区间，进行reverse，变成升序，就是下一个排列
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。  1,2,3 中的  2,3
        // 这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
        while (i >= 0 && nums[i] >= nums[i + 1]) { //1,2,3,4,3,2,1  i记录第一个3的位置,此时 [i+1,n) 必然是下降序列。
            i--;//标记，从后往前保持降序，遇到的第一个破坏降序的数字，记录其下标i
        }
        //                            1,2,3,4,3,2,1 i位置是第一个3， 从后边 4,3,2,1找到第一个 比3大的数a[j]，这里是4
        //如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]。这样「较大数」即为 a[j]。
        //交换 a[i]与 a[j]，此时可以证明区间 [i+1,n) 必为降序。 1,2,4,3,3,2,1 其中，3,3,2,1为降序
        // 我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;//从后往前，找到区间[i+1,n)中第一个比i位置上数字大的数字的下标
            }
            swap(nums, i, j);//交换两个位置的数字，然后把[i+1,n)进行reverse
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
