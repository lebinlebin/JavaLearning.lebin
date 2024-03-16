package Java.lebin.Training.InterviewCases.binarySearch;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
整数 a 比整数 b 更接近 x 需要满足：
|a - x| < |b - x| 或者
|a - x| == |b - x| 且 a < b

示例 1：
输入：arr = [1,2,3,4,5], k = 4, x = 3
输出：[1,2,3,4]
示例 2：
输入：arr = [1,2,3,4,5], k = 4, x = -1
输出：[1,2,3,4]
 */
public class _658_排序好的数组找到K个最接近的元素_结果必须升序排序好 {
    /*
    方法一：排除法（双指针）
    以 arr = [1, 2, 3, 4, 5, 6, 7] , x = 5, k = 3 为例。
    思路分析：
    1、一个一个删，因为是有序数组，且返回的是连续升序子数组，所以每一次删除的元素一定是位于边界；
    2、一共 7 个元素，要保留 3 个元素，因此要删除 4 个元素；
    3、因为要删除的元素都位于边界，于是可以使用 双指针 对撞的方式确定保留区间，即“最优区间”。

    “排除法”的结论：（这个结论对于这道问题来说非常重要，可以说是解题的关键）
    如果 x 的值就在长度为 size 区间内（不一定相等），要得到 size - 1 个符合题意的最接近的元素，此时看左右边界：
    1、如果左边界距离 x 较近，删除右边界；
    2、如果右边界距离 x 较近，删除左边界；
    3、如果左、右边界距离 x 的长度相等，删除右边界。
     */
    //时间复杂度：O(N)，这里N 是数组的长度；
    //空间复杂度：O(1)，只使用了常数个额外的辅助空间。
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    /*
    方法二：二分查找最优区间的左边界
    1、题目要求返回的是区间，并且是连续区间；
    2、区间长度是固定的，并且 k 的值为正数，且总是小于给定排序数组的长度，即 k 的值“不违规”；
    因此，只要我们找到了左边界的索引，从左边界开始数 k 个数，返回就好了。
    我们把这件事情定义为“寻找最优区间”，“寻找最优区间”等价于“寻找最优区间的左边界”。
    因此本题使用二分查找法在有序数组中定位含有 k 个元素的连续子区间的左边界，即使用二分法找“最优区间的左边界”。
     */
    //时间复杂度：O(logN)，这里N 是数组的长度，使用二分法的时间复杂度是对数级别的；
    //空间复杂度：O(1)，只使用了常数个额外的辅助空间。
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - k;
        //最优左边界一定位于下标范围[0,size - k)之间
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;//移位运算符,表示无符号右移。
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int k = 3;
        int x = 5;
        List<Integer> res = findClosestElements(arr, k, x);
        System.out.println(res);
    }
}
