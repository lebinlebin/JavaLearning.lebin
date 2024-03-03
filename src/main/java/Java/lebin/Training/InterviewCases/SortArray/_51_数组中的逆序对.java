package Java.lebin.Training.InterviewCases.SortArray;

import java.util.HashMap;
import java.util.Map;

/**
 剑指 Offer 51. 数组中的逆序对
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 输入一个数组，求出这个数组中的逆序对的总数。
 示例 1:
 输入: [7,5,6,4]
 输出: 5
 */
public class _51_数组中的逆序对 {
    //归并计数法。分治算法
    //O(nlogn)就是归并排序的时间复杂度
    //空间复杂度O(n)
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        //会修改原始数组，所以这里需要复制一份
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        //辅助数组，用于归并两个有序数组
        int[] temp = new int[len];
        //递归函数，对于copy数组的子区间，(0~len-1),左闭右闭的区间，计算逆序对的个数
        return reversePairs(copy, 0, len - 1, temp);
    }
    //递归方法
    //在 [left,right]区间计算逆序对个数，并且排序
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        //递归，第一考虑递归终止条件
        if (left == right) {
            return 0;
        }
        //至少有两个元素，这个算法是避免left和right都非常大的时候left+right会整形溢出，因此改成如下方法
        int mid = left + (right - left) / 2;
        //分别对这个子区间的前半部分和后半部分进行子区间逆序对计算
        int leftPairs = reversePairs(nums, left, mid, temp);//[left,mid] 都是左闭右闭的区间
        int rightPairs = reversePairs(nums, mid + 1, right, temp);//[mid+1,right] 左闭右闭的区间
        //归并排序的优化。在合并两个有序数组之前，如果能够检测到数组已经是有序的了。就不需要合并了
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        //对跨域两个区间的逆序对做计算
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        //对三部分逆序对进行加和
        return leftPairs + rightPairs + crossPairs;
    }
    //nums[left,...,mid] 需要是有序的，nums[mid+1,...,right]需要是有序的
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        //拷贝到辅助数组中。
        // 为什么全局使用一个辅助数组进行合并计算呢？
        // 1)这是因为每一次调用都创建一个新的辅助数组，会产生比较大的空间复杂度，以及创建数组和销毁数组的资源消耗。
        // 2) 如果使用新创建一个数组进行归并，由于我们只是对子区间进行一个copy，我们还要处理数组下标的偏移，比较容易出错
        for (int i = left; i <= right; i++) {//闭区间，这里<=
            temp[i] = nums[i];
        }
        int i = left;//指向第一个元素下标
        int j = mid + 1;//指向第一元素下标

        int count = 0;//计数器变量
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {//i超出范围，只能将j归并回去，因为i=mid+1，逆序对不需要计数。
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {//j超出范围，只能将i归并回去
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {//i先进行归并，如果这里写< 归并排序就不是一个稳定的排序
                nums[k] = temp[i];//i归并回去
                i++;//归并回去后 i++
            } else {//反面就是j要归并回去
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);//逆序对的个数加到计数变量中
            }
        }
        return count;//返回计数器变量
    }


    //=======================================================================
    //暴力解法，超时
    // 枚举所有的数对
    //只要发现一个逆序关系，就给计数器加1
    //复杂度  时间复杂度 O(n^2); 空间复杂度O(1)
    public int reversePairs2(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(nums[i]>nums[j]){
                    res ++;
                }
            }
        }
        return  res;
    }
}
