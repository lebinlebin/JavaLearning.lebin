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
//时间复杂度：O(N)
//空间复杂度：O(∣Σ∣) 其中 Σ 为字符集合
public class _316_去除重复字母 {
    public String removeDuplicateLetters(String s) {
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
}
