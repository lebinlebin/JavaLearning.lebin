package Java.lebin.Training.InterviewCases.SortArray;

import java.util.HashMap;
import java.util.Map;

/**
 剑指 Offer 56 - I. 数组中数字出现的次数
 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 示例 1：
 输入：nums = [4,1,4,6]
 输出：[1,6] 或 [6,1]
 */
/*
位运算
题目要求时间复杂度 O(N) ，空间复杂度 O(1)，因此首先排除 暴力法 和 哈希表统计法 。
*/
public class 剑指Offer56I数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        //相同的数字异或为0，任何数字与0异或结果是其本身。
        // 如果一个数组中其他数出现了两次，只有一个数出现了一次，直接全员异或得到的结果就是我们要求的
        //所以遍历异或整个数组最后得到的结果就是两个只出现一次的数字异或的结果：
        //设 x 和 y是两个只出现一次的数字。
        // 即 z = x ^ y
        int z = 0;
        for(int i : nums) {z ^= i;}
        //因为x和y是不相等的，因此二进制中一定有一位是不相等的。不同的。异或的性质：z中至少有一位是1，否则x与y就是相等的。
        //通过辅助变量m来保存z中哪一位为1.（可能有多个位都为1，找到最低位的1即可）。举个例子：z = 10 ^ 2 = 1010 ^ 0010 = 1000,第四位为1.
        //将m初始化为1，如果（z & m）的结果等于0说明z的最低位是0；每次将m左移一位然后跟z做与操作，直到结果不为0.
        //此时m应该等于1000，同z一样，第四位为1.
        int m = 1;
        while((z & m) == 0) {m <<= 1;}//m应该等于1000，同z一样，第四位为1.
        //遍历数组，将每个数跟m进行与操作，结果为0的作为一组，结果不为0的作为一组。那么就可以把x和y分别放到两个子数组当中
        //例如对于数组：[1,2,10,4,1,4,3,3]，我们把每个数字跟1000做与操作，可以分为下面两组：
        //nums1存放结果为0的: [1, 2, 4, 1, 4, 3, 3]
        //nums2存放结果不为0的: [10] (碰巧nums2中只有一个10，如果原数组中的数字再大一些就不会这样了)
        //问题已经退化为数组中有一个数字只出现了一次
        //分别对nums1和nums2遍历异或就能得到预期的x和y
        int x = 0, y = 0;
        for(int i : nums) {
            //这里我们是通过if...else将nums分为了两组，一边遍历一遍异或。
            //跟我们创建俩数组nums1和nums2原理是一样的。
            if((i & m) == 0) x ^= i;
            else y ^= i;
        }
        return new int[]{x, y};
    }
}
