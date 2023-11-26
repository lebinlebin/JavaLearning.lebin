package Java.lebin.Training.InterviewCases.characterString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 */
/**
 * 滑动窗口为固定长度
 * 比较题 Arrays.equals
 * 将hashMap换成数组进行优化
 */
/*
时间复杂度：O(m+(n−m)×Σ)，其中 n 为字符串 s 的长度，m 为字符串 p 的长度，Σ 为所有可能的字符数。
我们需要 O(m) 来统计字符串 p 中每种字母的数量；需要 O(m) 来初始化滑动窗口；
需要判断 n−m+1 个滑动窗口中每种字母的数量是否与字符串 p 中每种字母的数量相同，每次判断需要 O(Σ) 。
因为 s 和 p 仅包含小写字母，所以 Σ=26。
空间复杂度：O(Σ)。用于存储字符串 p 和滑动窗口中每种字母的数量。26
 */
public class _438_找到字符串中所有字母异位词 {
	public List<Integer> findAnagrams(String s, String p) {
		//两个string，需要两个hashMap，或者说是两个固定数组
		//其中一个作为groudtruth
		//记录p的所有字母及其个数
		char[] groudtruth = new char[26];
		//groud truth
		for (int i = 0; i < p.length(); i++) {
			groudtruth[p.charAt(i) - 'a']++;
		}
		//start和end分别控制窗口的前端和后端
		int start = 0, end = 0;
		char[] window = new char[26];

		List<Integer> ans = new ArrayList<Integer>();

		while (end < s.length()) {
			//这里做优化，采用数组替代HashMap
			window[s.charAt(end) - 'a']++; //加入窗口数据
			//缩减条件，或者加入答案的条件是:窗口内词语need词相同
			//                                          这里必须(end >= start) >=保证当p字符只有一个时候的情况
			while ((end - start + 1 == p.length()) && (end >= start)) { //维护一个长度为p.length()的窗口，并更新答案
				//满足要求更新答案，不满足不更新;
				//need更新后就不变了每次都是新的window和need进行比较
				if (Arrays.equals(window, groudtruth))
					ans.add(start);//更新答案
				//在滑动窗口离开前，把本次加入的start字符从数组中删除，然后start++
				window[s.charAt(start) - 'a']--;
				start++;
			}
			end++;
		}
		return ans;
	}
}
