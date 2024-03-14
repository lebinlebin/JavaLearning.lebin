package Java.lebin.Training.InterviewCases.characterString;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
例如， “ace” 是 “abcde” 的子序列。
示例 1:
输入: s = "abcde", words = ["a","bb","acd","ace"]
输出: 3
解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
Example 2:
输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
输出: 2
 */
/*
不妨将 words 中的所有单词根据首字母来分桶，即：把所有单词按照首字母分到 26 个桶中，每个桶中存储的是所有以该字母开头的所有单词。
比如对于 words = ["a", "bb", "acd", "ace"]，我们得到以下的分桶结果：
a: ["a", "acd", "ace"]
b: ["bb"]
然后我们从 s 的第一个字符开始遍历，假设当前字符为 'a'，我们从 'a' 开头的桶中取出所有单词。对于取出的每个单词，如果此时单词长度为 1，说明该单词已经匹配完毕，
我们将答案加 1；否则我们将单词的首字母去掉，然后放入下一个字母开头的桶中，比如对于单词 "acd"，去掉首字母 'a' 后，我们将其放入 'c' 开头的桶中。这一轮结束后，分桶结果变为：
c: ["cd", "ce"]
b: ["bb"]
遍历完 s 后，我们就得到了答案。
 */
public class _792_匹配子序列的单词数_字符串s和字符数组words的匹配 {
    //时间复杂度 O(n+∑i=0,m−1  ∣wi∣)
    //空间复杂度 O(m)。其中 n 和 m 分别为 s 和 words 的长度，而 ∣wi∣ 为 words[i]的长度。
    public int numMatchingSubseq(String s, String[] words) {
        //分桶
        Deque<String>[] d = new Deque[26];
        for (int i = 0; i < 26; ++i) {
            d[i] = new ArrayDeque<>();
        }
        for (String w : words) {
            d[w.charAt(0) - 'a'].add(w);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Deque<String> q = d[c - 'a'];
            for (int k = q.size(); k > 0; --k) {
                String t = q.pollFirst();
                if (t.length() == 1) {
                    ++ans;
                } else {
                    d[t.charAt(1) - 'a'].offer(t.substring(1));
                }
            }
        }
        return ans;
    }
}
