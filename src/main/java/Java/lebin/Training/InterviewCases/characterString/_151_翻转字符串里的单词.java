package Java.lebin.Training.InterviewCases.characterString;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 */
/*
时间复杂度：O(n)，其中  n 为输入字符串的长度。
空间复杂度：O(n)，双端队列存储单词需要 O(n) 的空间。
 */
/**
 * 1.去除首尾以及中间多余空格
 * 2.反转整个字符串
 * 3.反转各个单词
 */
public class _151_翻转字符串里的单词 {
    public static String reverseWords(String s) {
    	if (s == null) return "";
    	char[] chars = s.toCharArray();
    	// 消除多余的空格
    	// 字符串最终的有效长度
    	int len = 0;
    	// 当前用来存放字符的位置
    	int cur = 0;
    	// 前一个字符是否为空格字符
    	boolean space = true;
    	//去除空格
    	for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') { // chars[i]是非空格字符
				chars[cur++] = chars[i];
				space = false;
			} else if (space == false) { // chars[i]是空格字符，chars[i - 1]是非空格字符
				chars[cur++] = ' ';
				space = true;
			}
		}
    	len = space ? (cur - 1) : cur;

    	if (len <= 0) return "";
    	// 对整一个有效字符串进行逆序
    	reverse(chars, 0, len);

    	// 对每一个单词进行逆序
    	// 前一个空格字符的位置（有-1位置有个假想的哨兵，就是一个假想的空格字符）
    	int prevSapceIdx = -1;
    	for (int i = 0; i < len; i++) {
			if (chars[i] != ' ') continue;
			// i是空格字符的位置
			reverse(chars, prevSapceIdx + 1, i);
			prevSapceIdx = i;
		}
    	// 翻转最后一个单词
    	reverse(chars, prevSapceIdx + 1, len);
    	return new String(chars, 0, len);
    }

    /**
     * 将[li, ri)范围内的字符串进行逆序
     */
    private static void reverse(char[] chars, int li, int ri) {
    	ri--;//左闭右开，右边减一
    	while (li < ri) {
    		char tmp = chars[li];
    		chars[li] = chars[ri];
    		chars[ri] = tmp;
    		li++;
    		ri--;
    	}
    }
    public static void main(String[] args) {
		System.out.println("666_" + reverseWords("") + "_666");
		System.out.println("666_" + reverseWords("  hello world!     ") + "_666");
		System.out.println("666_" + reverseWords("a good   example") + "_666");
		System.out.println("666_" + reverseWords("are you ok") + "_666");
	}
}
