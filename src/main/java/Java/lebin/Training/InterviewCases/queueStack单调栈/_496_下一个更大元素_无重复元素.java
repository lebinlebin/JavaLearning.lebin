package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 */
//时间复杂度：O(n)
//空间复杂度：O(n)
//维持栈是单调递减
public class _496_下一个更大元素_无重复元素 {
	//nums1是nums2的子集
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if(null == nums2|| null == nums1) return null;
		// 在2中查，建立和1相同的长度的数组。
		// 转化为记录2中的nums[i]右边第一个比自己大的元素。
		// 然后从nums1的map中去get即可
		Stack<Integer> ss =  new Stack<>();
		//记录第二个数组的值和索引，方便查找
		Map<Integer,Integer>  map = new HashMap<>();
		for(int i=0;i < nums2.length; i++){
			map.put(nums2[i],i);//key是nums的数组元素取值，value是数组对应的index
		}

		int[] result = new int[nums2.length];
		int[] resultbak = new int[nums1.length];

		for(int i=0; i < nums2.length;i++){
			result[i] = -1;
		}
		//遍历nums2进行计算，result中存储的是nums2对应位置右边第一个比自己大的元素数值
		for(int i=0; i < nums2.length; i++){
			while(!ss.isEmpty() && nums2[i] > nums2[ss.peek()]){
				//栈中存储的 index
				result[ss.peek()] = nums2[i];//nums2[ss.peek()]的右边第一个比比自己大的值是nums2[i]
				ss.pop();//维持栈是单调递减的，栈底元素最大，栈顶元素最小。
			}
			//对于一直比当前元素小的其他数组元素，需要一直push，直到找到第一个比自己大的元素，才不进行push，进行while循环的pop操作。
			ss.push(i);//入栈
		}

		//从map中取出来
		for(int i = 0; i < nums1.length; i++){
			int index = map.get(nums1[i]); //获得在nums2中对应的下标
			resultbak[i] = result[index];  //第一个比当前下标的数大的数字
		}
		return resultbak;
	}

}
