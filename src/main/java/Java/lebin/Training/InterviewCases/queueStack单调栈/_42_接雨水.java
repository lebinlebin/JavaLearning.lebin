package Java.lebin.Training.InterviewCases.queueStack单调栈;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
 */
import java.util.Stack;
public class _42_接雨水 {
    //单调栈 左右两边找第一个比自己高的柱子，然后计算面积，这里计算是横向计算的。
    //时间复杂度：O(n)，其中 n 是数组 height 的长度。从 0 到 n−1 的每个下标最多只会入栈和出栈各一次。
    //空间复杂度：O(n)。空间复杂度主要取决于栈空间，栈的大小不会超过 n。
    public int trap3(int[] height){
        int size = height.length;
        if (size <= 2) return 0;
        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<Integer>();//把下标压入栈
        stack.push(0);
        int sum = 0;
        for (int index = 1; index < size; index++){//index =0 已经入栈
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){//找右边第一个比自己大的元素下标
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //找到了第一个比自己大的元素
                int heightAtIdx = height[index];//right元素 右边第一个比要计算积水面积的元素大的元素
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){//stackTop是当前遍历元素的上一个元素，是一个局部的最小，也是要计算积水面积的元素
                    int mid = stack.pop();//基准元素，比当前元素小的左边第一个元素，要计算积水面积的元素
                    if (!stack.isEmpty()){
                        int left = stack.peek();//left元素，左边比stackTop元素第一个大的元素
                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                        stackTop = stack.peek();//左边的元素变成要计算积水面积的下一个元素
                    }
                }//直到计算到获得左边需要计算积水面积元素要比 heightAtIdx 大的元素终止
                stack.push(index);//把当前遇到的最高的元素入栈。栈中从栈底到栈顶元素递减
            }
        }
        //遍历完所有index返回最终结果
        return sum;
    }


    //因为每次遍历列的时候，还要向两边寻找最高的列，所以时间复杂度为O(n^2)，空间复杂度为O(1)。
    // 思路:找到自己(i)两边，左边比自己高的最高的柱子；右边找到比自己高的最高的柱子；
    // 选择两者的最小值，然后计算当前位置积水的面积(按照列进行计算)
    //当前列雨水面积：min(左边柱子的最高高度，右边柱子的最高高度) - 当前柱子高度。
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i==0 || i== height.length - 1) continue;

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i+1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            //左边最高的柱子
            for (int l = i-1; l >= 0; l--) {
                if(height[l] > lHeight) lHeight = height[l];
            }

            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    /*
    避免重复计算，以空间换时间
    当前列雨水面积：min(左边柱子的最高高度，右边柱子的最高高度) - 当前柱子高度。
    为了得到两边的最高高度，使用了双指针来遍历，每到一个柱子都向两边遍历一遍，是有重复计算的。
    我们把每一个位置的左边最高高度记录在一个数组上（maxLeft），右边最高高度记录在一个数组上（maxRight），这样就避免了重复计算。
    当前位置，左边的最高高度是前一个位置的左边最高高度和本高度的最大值。
    即从左向右遍历：maxLeft[i] = max(height[i], maxLeft[i - 1]);
    从右向左遍历：maxRight[i] = max(height[i], maxRight[i + 1]);
     */
    //时间复杂度：O(n)，其中 n 是数组 height 的长度。两个指针的移动总次数不超过 n。
    //空间复杂度：O(n)。
    public int trap2(int[] height) {
        if (height.length <= 2) return 0;
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i< length; i++) maxLeft[i] = Math.max(height[i], maxLeft[i-1]);

        // 记录每个柱子右边柱子最大高度
        maxRight[length - 1] = height[length - 1];
        for(int i = length - 2; i >= 0; i--) maxRight[i] = Math.max(height[i], maxRight[i+1]);

        // 求和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }

}
