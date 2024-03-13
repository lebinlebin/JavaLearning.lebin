package Java.lebin.Training.InterviewCases.characterString;
import java.util.Arrays;
/*
179. 最大数
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
示例 1：
输入：nums = [10,2]
输出："210"
示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"
 */
public class _179_最大数_重排列非负整数数组使之成为最大的整数 {
/*
时间复杂度：由于是对 String进行排序，当排序对象不是 Java 中的基本数据类型时，
不会使用快排（考虑排序稳定性问题）。Arrays.sort() 的底层实现会「元素数量/元素是否大致有序」
决定是使用插入排序还是归并排序。这里直接假定使用的是「插入排序」。复杂度为 O(n^2).
空间复杂度：O(n)
 */
    public static  String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];

        //转化为字符串
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        //以字符串进行比较 '2'>'10'
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        for(String S:strs){
            System.out.println(S);
        }
        if (strs[0].equals("0"))
            return "0";
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }


    public String largestNumber2(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,2};
        System.out.println(largestNumber(nums));
    }
}
