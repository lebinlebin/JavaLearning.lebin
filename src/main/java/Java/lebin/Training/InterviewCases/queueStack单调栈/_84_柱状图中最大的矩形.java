package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Stack;
/*
84.柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
//单调栈解法
public class _84_柱状图中最大的矩形 {
    //42. 接雨水 (opens new window)是找每个柱子左右两边第一个大于该柱子高度的柱子，而本题是找每个柱子左右两边第一个小于该柱子的柱子。
    // 本题是要找每个柱子左右两边第一个小于该柱子的柱子，所以从栈头（元素从栈头弹出）到栈底的顺序应该是从大到小的顺序！
    // 关键的三个数值，当前基准元素mid，左边第一个比基准元素小的元素left，右边第一个比基准小的元素right
    //栈顶元素就是基准元素mid，
    //以基准元素计算的矩形面积有多个结果，我们取最大的那个
    int largestRectangleArea2(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        // 数组扩容，在头和尾各加入一个元素
        //末尾加一个0: 目的是 为了 比如[2,4,6,8]本来就是递增的数组，入栈时候 8，6，,4, 2那么永远遇不到代码中收集结果的当前元素小于栈顶元素的时候，那么程序就跑不出结果
        //首元素为啥要加一个0?  比如[8, 6, 4, 2],第一个元素入栈  8，，第二个元素就比8小，那么我们就要收集结果，而收集结果必须要 left mid 和right。 栈顶元素是mid=8，right=6，，没有left。
        // left应该是数组中8前边的元素，而数组中8前边没有元素
        //------------数组前后加0------------------
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        //---------------------------------------

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {//压栈，目的是栈底到栈顶从小到大，栈顶元素最大
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while //当当前元素比栈顶元素小的时候，开始收集结果，弹出栈顶元素
                    int mid = st.peek();//基准元素
                    st.pop();
                    int left = st.peek();//left
                    int right = i;//当前元素 i
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);//收集最大的那个
                }
                st.push(i);
            }
        }
        return result;
    }

    // 暴力解法: 时间复杂度是O(n^2)。
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] minLeftIndex = new int [length];
        int[] minRightIndex = new int [length];
        // 记录左边第一个小于该柱子的下标
        minLeftIndex[0] = -1 ;
        for (int i = 1; i < length; i++) {
            int t = i - 1;
            // 这里不是用if，而是不断向右寻找的过程
            while (t >= 0 && heights[t] >= heights[i]) t = minLeftIndex[t];
            minLeftIndex[i] = t;
        }
        // 记录每个柱子右边第一个小于该柱子的下标
        minRightIndex[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int t = i + 1;
            while(t < length && heights[t] >= heights[i]) t = minRightIndex[t];
            minRightIndex[i] = t;
        }
        // 求和
        int result = 0;
        for (int i = 0; i < length; i++) {
            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }
}
