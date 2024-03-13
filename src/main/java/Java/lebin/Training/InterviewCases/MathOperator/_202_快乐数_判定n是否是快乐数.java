package Java.lebin.Training.InterviewCases.MathOperator;

import java.util.HashSet;
import java.util.Set;

/**
 编写一个算法来判断一个数 n 是不是快乐数。
 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 如果 可以变为  1，那么这个数就是快乐数。
 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 示例：
 输入：19
 输出：true
 解释：
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 思路
 这道题目看上去貌似一道数学问题，其实并不是！
 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
 这道题目使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
 判断sum是否重复出现就可以使用set。
 还有一个难点就是求和的过程，如果对取数值各个位上的单数操作不熟悉的话，做这道题也会比较艰难。
 */
//时间复杂度 O(logn)
//空间复杂度 O(logn)//具体计算逻辑需要去查
public class _202_快乐数_判定n是否是快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {//快乐数定义加和
            int temp = n % 10;//各位数
            res += temp * temp;
            n = n / 10;
        }
        return res;//做了一次快乐数的定义计算来到下一个数
    }
}
