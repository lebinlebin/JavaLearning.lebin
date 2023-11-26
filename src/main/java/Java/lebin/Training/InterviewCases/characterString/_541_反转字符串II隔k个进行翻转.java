package Java.lebin.Training.InterviewCases.characterString;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 */
/*
时间复杂度：O(n)，其中 n 是字符串 s 的长度。
空间复杂度：O(1) 或 O(n)，取决于使用的语言中字符串类型的性质。
如果字符串是可修改的，那么我们可以直接在原字符串上修改，空间复杂度为O(1)，否则需要使用 O(n) 的空间将字符串临时转换为可以修改的数据结构（例如数组），空间复杂度为 O(n)。
 */
public class _541_反转字符串II隔k个进行翻转 {
	public String reverseStr(String s, int k) {
		char[] ch = s.toCharArray();
		for(int i = 0;i < ch.length;i += 2 * k){
			int start = i;
			// 判断尾数够不够k个来取决end指针的位置
			int end = Math.min(ch.length - 1,start + k - 1);
			while(start < end){
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				start++;
				end--;
			}
		}
		return new String(ch);
	}
}
