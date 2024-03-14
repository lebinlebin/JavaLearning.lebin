package Java.lebin.Training.InterviewCases.characterString;

import Java.lebin.Training.DSA._04_Queue.Deque;

import java.util.ArrayDeque;
/*
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
示例 1：
输入：s = "bcabc"
输出："abc"
示例 2：
输入：s = "cbacdcbc"
输出："acdb"
 */
/*
考虑一个简单的问题：给定一个字符串 s，如何去掉其中的一个字符 ch，使得得到的字符串字典序最小呢？
答案是：找出最小的满足 s[i]>s[i+1] 的下标 i，并去除字符 s[i]。为了叙述方便，下文中称这样的字符为「关键字符」。
使用单调栈来维护去除「关键字符」后得到的字符串，单调栈满足栈底到栈顶的字符递增。
如果栈顶字符大于当前字符 s[i]，说明栈顶字符为「关键字符」，故应当被去除。
去除后，新的栈顶字符就与 s[i] 相邻了，我们继续比较新的栈顶字符与 s[i]的大小。
重复上述操作，直到栈为空或者栈顶字符不大于 s[i]。
----------------------
在考虑字符 s[i] 时，如果它已经存在于栈中，则不能加入字符 s[i]。为此，需要记录每个字符是否出现在栈中。
在弹出栈顶字符时，如果字符串在后面的位置上再也没有这一字符，则不能弹出栈顶字符。
为此，需要记录每个字符的剩余数量，当这个值为 0 时，就不能弹出栈顶字符了。
 */
//时间复杂度：O(N)
//空间复杂度：O(∣Σ∣) 其中 Σ 为字符集合
public class _316_去除重复字母_字典序最小_单调栈 {
    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;//字符最后出现的下标
        }
//        Deque<Integer> stack = new ArrayDeque<Integer>();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        boolean[] visit = new boolean[26];

        for (int i = 0; i < len; i++) {
            if (visit[charArray[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visit[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visit[charArray[i] - 'a'] = true;
        }
        StringBuffer sb = new StringBuffer();
        for (char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "bcabc";
        System.out.println(removeDuplicateLetters(str));
    }
}
