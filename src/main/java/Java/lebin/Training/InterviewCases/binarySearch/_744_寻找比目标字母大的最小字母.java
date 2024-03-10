package Java.lebin.Training.InterviewCases.binarySearch;
/*
给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。

示例 1：
输入: letters = ["c", "f", "j"]，target = "a"
输出: "c"
解释：letters 中字典上比 'a' 大的最小字符是 'c'。
示例 2:
输入: letters = ["c","f","j"], target = "c"
输出: "f"
解释：letters 中字典顺序上大于 'c' 的最小字符是 'f'。
示例 3:
输入: letters = ["x","x","y","y"], target = "z"
输出: "x"
解释：letters 中没有一个字符在字典上大于 'z'，所以我们返回 letters[0]。
 */

public class _744_寻找比目标字母大的最小字母 {
/*
1. 题目要求找严格大于 j 的第 1 个位置，因此这道题特别像第 35 题，因此搜索范围是 [0, len]，注意，不是 [0, len - 1]。
2、根据题意：小于等于一定不是解，先写 letters[mid] <= target 这个分支，得到下一轮搜索的区间是：[mid + 1, right]，即 left = mid + 1，这一点确定了以后，反面就是 right = mid，分支这样写，不用调整成右中位数；
3、需要后处理：还是上面那个示例，如果找到的位置超出了 len - 1，就说明找不到，可根据题意，返回第 0 号索引元素，否则返回查找到的那个位置的元素。
 */
    // 比目标字母大的最小字母
    // 找严格大于 target 的第 1 个位置
//    参考代码 1：特殊判断放在最后面，此时要注意二分搜索初始化的右边界。
//    时间复杂度：O(logn)，其中 n 是列表 letters的长度。二分查找的时间复杂度是 O(logn)。
//    空间复杂度：O(1)。
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        // 转换为第 35 题：其实就是找插入元素的位置
        // 搜索范围 [0, len]
        int left = 0;
        // 分析这一步特别重要
        int right = len;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (letters[mid] <= target){
                // 下一轮搜索的区间是：[mid + 1, right]
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        // 因为有可能不存在
        if (left == len){
            return letters[0];
        }
        return letters[left];
    }
    /*
    当然，最特殊的判断也可以放在最前面。
参考代码 2：一开始就做特殊判断，接下来就可以确定在 [0, len - 1] 范围里一定有解，无需后处理。
     */
    public char nextGreatestLetter2(char[] letters, char target) {
        int len = letters.length;

        if (target >= letters[len - 1]) {
            return letters[0];
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (letters[mid] <= target) {
                // 下一轮搜索的区间是：[mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }
}
