package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;

/*
数组 A 中给定可以使用的 1~9 的数，返回由数组 A 中的元素组成的小于 n 的最大数。
示例 1：A={1, 2, 9, 4}，n=2533，返回 2499。
示例 2：A={1, 2, 5, 4}，n=2543，返回 2542。
示例 3：A={1, 2, 5, 4}，n=2541，返回 2525。
示例 4：A={1, 2, 9, 4}，n=2111，返回 1999。
示例 5：A={5, 9}，n=5555，返回 999。
 */
/*
回溯
对每一位先尝试使用相同数字，直到最后一位或者没有相同的数字时，尝试是否有比当前数字更小的，
有的话选更小的数字里最大的，剩下的用最大数字；都没有就向前回溯看前一个有没有更小的。
如果一直回溯到第一个数字，就用位数更少的全都是最大数字的数。

我想的很简单，就是一个回溯，每次选一个数，但是选的数的位数不能超过Target(比如target是9999四位数，
那我最多选择四个数，否则五位数一定比四位数大)。然后每次选好了，只要比target小，我们就记录一下Max值就好啦。
 */
public class 小于n的最大数 {
    public static void main(String[] args) {
        int num = 2000;
        int numns [] = new int[]{1,2,4,9};
        System.out.println(getMax(num, numns));
    }
    public static int max = Integer.MIN_VALUE;
    public static int len ;
    public static int targetNum;
    public static int [] nums;
    public static int getMax(int target, int [] array){
        Arrays.sort(array);
        int length = (target + "").length();//转化成字符求长度
        targetNum = target;
        len = length;
        nums = array;
        dfs(0,0);
        return max;
    }

    private static void dfs(int cur, int curLen) {
        max = Math.max(max,cur);
        if(curLen == len) return;
        for(int i = 0; i < nums.length;i++){
            int tem  = cur *10 + nums[i];
            if(tem >= targetNum){
                continue;
            }
            cur = cur * 10 + nums[i];
            curLen+=1;
            dfs(cur,curLen);
            cur /= 10;
            curLen -= 1;
        }
    }
}
