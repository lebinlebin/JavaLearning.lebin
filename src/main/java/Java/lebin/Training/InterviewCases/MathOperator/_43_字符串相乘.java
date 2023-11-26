package Java.lebin.Training.InterviewCases.MathOperator;

/**
 43. 字符串相乘
 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 示例 1:
 输入: num1 = "2", num2 = "3"
 输出: "6"
 */
/*	解题思路
	明确一点：两个数相乘后的结果的长度必定在[len1+len2-1,len1+len2]
	从后往前计算，按照笔算乘法的步骤。创建一个len1+len2长度的int数组，存放初步结果。
	最后对初步结果进行进位处理
	然后对int数组转化为String（要看数组第一位是不是0，如果是0，那说明长度为len1+len2-1，否则为len1+len2）
*/
//时间复杂度：O(mn)
// 空间复杂度：O(m+n)
public class _43_字符串相乘 {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int m = num1.length();
		int n = num2.length();
		//两个数相乘后的结果的长度必定在[len1+len2-1,len1+len2]
		int[] ansArr = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			int x = num1.charAt(i) - '0';
			for (int j = n - 1; j >= 0; j--) {
				int y = num2.charAt(j) - '0';
				ansArr[i + j + 1] += x * y;
			}
		}
		//从后向前
		for (int i = m + n - 1; i > 0; i--) {
			ansArr[i - 1] += ansArr[i] / 10;//处理进位
			ansArr[i] %= 10;
		}

		int index = ansArr[0] == 0 ? 1 : 0;
		StringBuffer ans = new StringBuffer();
		while (index < m + n) {
			ans.append(ansArr[index]);
			index++;
		}
		return ans.toString();
	}
}
