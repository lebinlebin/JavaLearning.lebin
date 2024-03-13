package Java.lebin.Training.InterviewCases.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
//时间复杂度是 O(M + N)，M 和 N 分别是字符串 S 和 T 的长度。
// 因为我们先用 for 循环遍历了字符串 T 来初始化 needs，时间 O(N)，之后的两个 while 循环最多执行 2M 次，时间 O(M)。
//读者也许认为嵌套的 while 循环复杂度应该是平方级，但是你这样想，while 执行的次数就是双指针 left 和 right 走的总路程，最多是 2M 嘛。
//空间复杂度 O(M+N)
public class _76_最小覆盖子串_s中涵盖t所有字符的最小子串 {
	private Map<Character, Integer> targetMap;
	private Map<Character, Integer> curMap;

	public String minWindow(String s, String t) {
		//两个串需要两个map，其中一个作为 groudtruth即 targetMap
		targetMap = new HashMap<>();
		curMap = new HashMap<>();
		// 首先对 t 中的字符进行个数统计
		for (char c : t.toCharArray()) targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);

		// left 是滑动窗口的左边界，right 是滑动窗口的右边界，ansLeft 是最终答案的左边界，ansRight 是最终答案的右边界
		int left = 0, right = 0, ansLeft = -1, ansRight = -1;
		int size = s.length();

		// len 用来记录滑动窗口最小的值是多少
		int len = Integer.MAX_VALUE;

		//总体是两个while循环
		while (right < size) {
			char c = s.charAt(right);
			// 对窗口右边界进行读入，并将对应的字符个数进行累加和
			//对窗口数据进行读入map，然后进入while(check)循环。重点在于两个map的对接。
			if (targetMap.containsKey(c)) {
				curMap.put(c, curMap.getOrDefault(c, 0) + 1);
			}

			// 缩减窗口条件。本题 当满足targetMap时候就可以进行缩减了，当缩减到curMap不满足条件targetMap为止。
			// 记录下left和right
			// 检查一下当前两个哈希表中的值是否符合要求，而且要求左边界不能超过右边界。进入while循环进行缩减窗口。left++
			while (check() && left <= right) {
				// 如果找到了更小的窗口，那么就进行更新操作
				if (right - left + 1 < len) {
					len = right - left + 1;
					ansLeft = left;
					ansRight = right + 1;
				}
				// 然后右移左边界，并吐出来之前左边界的字符统计个数
				if (targetMap.containsKey(s.charAt(left))) {
					curMap.put(s.charAt(left), curMap.getOrDefault(s.charAt(left), 0) - 1);
				}
				left++;
			}
			// 记得右移右边界，然后继续寻找
			right++;
		}
		// 如果答案的右边界没经过更新，说明没有找到符合要求的值，就直接返回空的好了，否则的话，就返回子字符串
		return ansRight == -1 ? "" : s.substring(ansLeft, ansRight);
	}



	// check两个map的count是否满足要求，即targetMap是否被curMap全部覆盖了。
	//覆盖的条件就是  curMap的key能够覆盖targetMap的key而且count>=1.
	//学习这种写法
	private boolean check() {
		// 检查两个哈希表中的值是否符合要求
		for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
			// 只要当前序列中某个字符的的个数小于要求的个数，就直接返回 false 就好了
			//满足要求的话至少要大于等于targetMap对应的数字，所以小于，就直接返回false
			if (curMap.getOrDefault(entry.getKey(), 0) < entry.getValue())
				return false;
		}
		return true;
	}
}
