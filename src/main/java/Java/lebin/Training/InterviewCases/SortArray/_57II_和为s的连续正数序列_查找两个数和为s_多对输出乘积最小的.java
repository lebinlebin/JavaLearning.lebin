package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.List;

/**
 剑指offer_42:输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
/*

1.定义两个指针，第一个指向第一个元素，第二个指向最后一个元素；
2.先拿第一个元素和最后一个元素相加，与要求的数字进行比较；
1）如果等于，恭喜找到了；
2）如果大于，则将第二个指针向后移一位（索引值－1），再求和进行比较；
3）如果小于，则将第一个指针向前移一位（索引值＋1），在进行求和比较；
直至找到结果。
在此补充说明：非常重要：
当时在写的时候一直纠结如何找到和是最小的那对数字，后来想明白了，第一个满足要求的肯定是乘积最小的。为什么？？？？？？
2 x 8  < 3 x 6 < 3x7。

我的补充如下：
有些地方讲的不清楚，我写了一个公式 ，自己去体会其中奥秘；
首先有一个递增数列，一个在开始端a，一个在末端b，b-a>1,他们之间包含很多数，记住递增哦，
a*b与（a+1）*（b-1）的关系怎么计算
（a+1）*（b-1）=ab-a+b-1 (1)
    a*b                 (2)
(1)-(2)>0
所以下面的代码，你只需要求出第一个数就完成了，不需要再排序了，明白？
 */

//   复杂度分析
//   窗口只向右移动，左右边界最多移动 target/2次，所以整体时间复杂度为O(N)。
//   空间复杂度：O(1)。
public class _57II_和为s的连续正数序列_查找两个数和为s_多对输出乘积最小的 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 先判断特殊情况：数字少于两个时
        if (array.length < 2 || array == null) {
            return list;
        }
        // 获取数组的长度
        int len = array.length;
        int start = 0;
        int end = len - 1;
        while (start < end && start < len - 1 && end > 0) {
            if (array[start] + array[end] == sum) {
                list.add(array[start]);
                list.add(array[end]);
                return list;

            }
            if (array[start] + array[end] > sum) {
                end--;
            }
            if (array[start] + array[end] < sum) {
                start++;
            }
        }
        return list;
    }
}
