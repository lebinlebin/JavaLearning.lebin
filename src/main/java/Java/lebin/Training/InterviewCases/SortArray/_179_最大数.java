package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;
import java.util.Comparator;

/*
179.最大数
题目描述
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:
输入: [10,2]
输出: 210
示例 2:
输入: [3,30,34,5,9]
输出: 9534330
说明:输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
/*
复杂度分析O(nlogn)
时间复杂度：尽管我们在比较函数中做了一些额外的工作，但是这只是一个常数因子。所以总的时间复杂度是由排序决定的

空间复杂度：O(n)
这里，我们使用了O(n)的额外空间去保存nums的副本。尽管我们就地进行了一些额外的工作，但最后返回的数组需要
 的空间。因此，需要的额外空间与nums大小成线性关系。
 */
public class _179_最大数 {
    private class LargerNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}
