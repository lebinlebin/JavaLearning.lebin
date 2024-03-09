package Java.lebin.Training.InterviewCases.SortArray;

import java.util.HashSet;
import java.util.Set;

/**
 189. 旋转数组
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 示例 1:
 输入: nums = [1,2,3,4,5,6,7], k = 3
 输出: [5,6,7,1,2,3,4]
  */
public class _189_旋转数组_向右移动k个位置 {
    /*
    数组翻转
    当将数组的元素向右移动 k 次后，尾部 k mod n 个元素会移动至数组头部，其余元素向后移动 k mod n 个位置。
    先将所有元素翻转，这样尾部的 k mod n 个元素就被移至数组头部，
    再翻转[0,kmodn−1] 区间的元素和[kmodn,n−1] 区间的元素
    以 n=7，k=3 为例进行如下展示：
    操作	结果
    原始数组	1~2~3~4~5~6~7
    翻转所有元素	7~6~5~4~3~2~1
    翻转[0,kmodn−1] 区间的元素	5~6~7~4~3~2~1
    翻转[kmodn,n−1] 区间的元素	5~6~7~1~2~3~4
     */
//    时间复杂度：O(n)，其中 n 为数组的长度。每个元素被翻转两次，一共 n 个元素，因此总时间复杂度为 O(2n)=O(n)。
//    空间复杂度：O(1)。

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
