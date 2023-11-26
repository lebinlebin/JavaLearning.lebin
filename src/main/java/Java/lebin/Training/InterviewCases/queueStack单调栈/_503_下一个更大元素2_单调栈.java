package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */
//时间复杂度：O(n)
//空间复杂度：O(n)
//将两个nums数组拼接在一起，使用单调栈计算出每一个元素的下一个最大值，最后再把结果集即result数组resize到原数组大小就可以了。
public class _503_下一个更大元素2_单调栈 {
	//nums1是nums2的子集
	public int[] nextGreaterElements(int[] nums) {
		//边界判断
		if(nums == null || nums.length <= 1) {
			return new int[]{-1};
		}
		int size = nums.length;
		int[] result = new int[size];//存放结果
		Arrays.fill(result,-1);//默认全部初始化为-1

		Stack<Integer> st= new Stack<>();//栈中存放的是nums中的元素下标
		for(int i = 0; i < 2*size; i++) {
			while(!st.empty() && nums[i % size] > nums[st.peek()]) {
				result[st.peek()] = nums[i % size];//更新result
				st.pop();//弹出栈顶
			}
			st.push(i % size);
		}
		return result;
	}
}
