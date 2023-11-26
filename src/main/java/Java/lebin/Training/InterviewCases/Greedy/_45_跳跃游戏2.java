package Java.lebin.Training.InterviewCases.Greedy;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
//贪⼼的思路，
// 局部最优：当前可移动距离尽可能多⾛，如果还没到终点，步数再加⼀。
// 整体最优：⼀步尽可能多⾛，从⽽达到最⼩步数。
//用最少的步数获得最大的覆盖范围。尽可能的增加覆盖范围
//时间复杂度: O(n)
//空间复杂度: O(1)
public class _45_跳跃游戏2 {
	public int jump(int[] nums) {
		if (nums.length == 1) return 0;
		int curDistance = 0;// 当前覆盖最远距离下标
		int result = 0;//记录⾛的最⼤步数
		int nextDistance = 0;// 下⼀步覆盖最远距离下标
		for (int i = 0; i < nums.length; i++) {
			nextDistance = Math.max(nums[i] + i, nextDistance);//更新下⼀步覆盖最远距离下标
			if (i == curDistance) {//遇到当前覆盖最远距离下标  两种情况要么当前下标就是终点直接break；要么当前位置距离终点还有段距离，需要循环result++
				if (curDistance != nums.length - 1) {//如果当前覆盖最远距离下标不是终点
					result++;//需要⾛下⼀步
					curDistance = nextDistance;//更新当前覆盖最远距离下标（相当于加油了）
					if (nextDistance >= nums.length - 1) break;//下⼀步的覆盖范围已经可以达到终点，结束循环.这一步要放在result++之后
				} else break;//当前覆盖最远距离下标是集合终点，不⽤做  result++ 操作了，直接结束
			}
		}
		return result;
	}
	public int jump2(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		//记录跳跃的次数
		int count=0;
		//当前的覆盖最大区域
		int curDistance = 0;
		//最大的覆盖区域
		int maxDistance = 0;

		for (int i = 0; i < nums.length; i++) {
			//在可覆盖区域内更新最大的覆盖区域
			maxDistance = Math.max(maxDistance,i+nums[i]);
			//说明当前一步，再跳一步就到达了末尾
			if (maxDistance>=nums.length-1){
				count++;
				break;
			}
			//走到当前覆盖的最大区域时，更新下一步可达的最大区域
			if (i==curDistance){
				curDistance = maxDistance;
				count++;
			}
		}
		return count;
	}
}
