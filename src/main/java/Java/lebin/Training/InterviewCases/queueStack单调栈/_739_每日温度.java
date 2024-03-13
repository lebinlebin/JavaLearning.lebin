package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/*
739. 每日温度
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class _739_每日温度 {
    /*
    通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。时间复杂度为O(n)。
    单调栈的本质是空间换时间，因为在遍历的过程中需要用一个栈来记录右边第一个比当前元素高的元素，优点是整个数组只需要遍历一次。
    在使用单调栈的时候首先要明确如下几点：
    1. 单调栈里存放的元素是什么？
    单调栈里只需要存放元素的下标i就可以了，如果需要使用对应的元素，直接T[i]就可以获取。
    2. 单调栈里元素是递增呢？ 还是递减呢？
    即：如果求一个元素右边第一个更大元素，单调栈就是递增的(栈顶元素最小，栈底元素最大)，
    如果求一个元素右边第一个更小元素，单调栈就是递减的(栈顶元素最大，栈底元素最小)。
     */
//    时间复杂度：O(n)
//    空间复杂度：O(n)
    public int[] dailyTemperatures1(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];
        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        //题目要求找到右边第一个比自己大的元素，那么要维护一个从栈顶到栈底单调增的栈空间，栈顶元素最小
        for(int i=1; i<lens; i++){
            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);//递减栈，压入的元素，一个比一个小，栈底元素最大
            }else{
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){//找到比自己更大的元素
                    res[stack.peek()] = i-stack.peek();//栈顶元素也就是栈中最小的元素，右边第一比自己大的元素距离自己的下标距离
                    stack.pop();//pop，一直pop到栈顶元素为空或者栈顶元素>当前i的元素的大小，进入if循环(不要忘记把i  push进入栈)
                }
                stack.push(i);
            }
        }
        return  res;
    }

    //暴力法  超时
    /*
    复杂度分析
    时间复杂度：O(n^2)
    空间复杂度：O(n)
     */
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
