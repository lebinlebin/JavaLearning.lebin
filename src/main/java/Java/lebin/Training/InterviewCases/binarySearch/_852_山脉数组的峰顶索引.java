package Java.lebin.Training.InterviewCases.binarySearch;
/*
符合下列属性的数组 arr 称为 山脉数组 ：
arr.length >= 3
存在 i（0 < i < arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组 arr ，返回满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。

示例 1：
输入：arr = [0,1,0]
输出：1
示例 2：
输入：arr = [0,2,1,0]
输出：1
示例 3：
输入：arr = [0,10,5,2]
输出：1
 */
public class _852_山脉数组的峰顶索引 {
    //时间复杂度：O(logN)，这里N 是输入数组的长度；
    //空间复杂度：O(1)。
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 1;
        int right = len - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // 下一轮搜索区间在 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
