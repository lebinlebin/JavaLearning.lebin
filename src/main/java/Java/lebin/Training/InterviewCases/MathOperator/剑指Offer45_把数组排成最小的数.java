package Java.lebin.Training.InterviewCases.MathOperator;

import java.util.Arrays;

/**
 1，题目描述
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
/*
题目分析：
要想数组中的元素拼接成最小数字，数组元素的需要把元素拼接后进行比较实用CompareTo()的方法，比如：[2,34,17] ，升序：21734,17234。
最后返回的是一个字符串
*/
public class 剑指Offer45_把数组排成最小的数 {

	/*
	解题思路：
	此题求拼接起来的最小数字，本质上是一个排序问题。设数组 nums 中任意两数字的字符串为 x 和 y ，则规定 排序判断规则 为：
	若拼接字符串 x+y>y+x ，则 x “大于” y ；
	反之，若 x+y<y+x ，则 x “小于” y ；
	x “小于” y 代表：排序完成后，数组中 x 应在 y 左边；“大于” 则反之。
	根据以上规则，套用任何排序方法对 nums 执行排序即可。

	算法流程：
	初始化： 字符串列表 strs ，保存各数字的字符串格式；
	列表排序： 应用以上 “排序判断规则” ，对 strs 执行排序；
	返回值： 拼接 strs 中的所有字符串，并返回。
	复杂度分析：
	时间复杂度 O(NlogN) ： N 为最终返回值的字符数量（ strs 列表的长度 ≤N ）；
	使用快排或内置函数的平均时间复杂度为O(NlogN) ，最差为 O(N^2)。
	空间复杂度 O(N) ： 字符串列表 strs 占用线性大小的额外空间。
	 */
	public String minNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
			strs[i] = String.valueOf(nums[i]);
		quickSort(strs, 0, strs.length - 1);
		StringBuilder res = new StringBuilder();
		for(String s : strs)
			res.append(s);
		return res.toString();
	}
	void quickSort(String[] strs, int l, int r) {
		if(l >= r) return;
		int i = l, j = r;
		String tmp = strs[i];
		while(i < j) {
			while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
			while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
			tmp = strs[i];
			strs[i] = strs[j];
			strs[j] = tmp;
		}
		strs[i] = strs[l];
		strs[l] = tmp;
		quickSort(strs, l, i - 1);
		quickSort(strs, i + 1, r);
	}

	/*
	内置函数：
	需定义排序规则：
	Java 定义为 (x, y) -> (x + y).compareTo(y + x) ；
	 */
	public String minNumber2(int[] nums) {
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
			strs[i] = String.valueOf(nums[i]);
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for(String s : strs)
			res.append(s);
		return res.toString();
	}

}
