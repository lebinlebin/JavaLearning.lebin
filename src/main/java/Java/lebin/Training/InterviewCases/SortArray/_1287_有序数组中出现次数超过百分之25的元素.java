package Java.lebin.Training.InterviewCases.SortArray;

/**
 1287. 有序数组中出现次数超过25%的元素
 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 请你找到并返回这个整数
 示例：
 输入：arr = [1,2,2,6,6,6,6,7,10]
 输出：6
 */
//时间复杂度：O(N)，其中 N是数组 arr 的长度。
//空间复杂度：O(1)。
public class _1287_有序数组中出现次数超过百分之25的元素 {
	public int findSpecialInteger(int[] arr) {
		double count = arr.length * 0.25;
		int targetNum = Integer.MIN_VALUE;
		int targetCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != targetNum) {
				targetNum = arr[i];
				targetCount = 1;
			}else {
				targetCount++;
			}
			if(targetCount > count) {
				return targetNum;
			}
		}

		return targetNum;
	}
}


