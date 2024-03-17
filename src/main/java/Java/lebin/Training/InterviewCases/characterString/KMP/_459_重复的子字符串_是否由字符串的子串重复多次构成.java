package Java.lebin.Training.InterviewCases.characterString.KMP;

import java.util.Arrays;

//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
/*
示例 1:
输入: s = "abab"
输出: true
解释: 可由子串 "ab" 重复两次构成。
 */
//时间复杂度：O(n)，其中 n 是字符串 s 的长度。
// 空间复杂度：O(n)。
public class _459_重复的子字符串_是否由字符串的子串重复多次构成 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;
        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        //最长公共前后缀
        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];

            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) j++;
            // 更新 next 数组的值
            next[i] = j;

        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组最长相等前后缀的数组的长度
        //len % (len - next[len]) == 0  说明是由 len - next[len] 范围长度的数组重复多次组成的
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
    //方法二：字符串匹配
    //既然前⾯有相同的⼦串，后⾯有相同的⼦串，⽤ s + s，这样组成的字符串中，后⾯的⼦串做前串，前后的⼦串
    //做后串，就⼀定还能组成⼀个s
    //所以判断字符串s是否由重复⼦串组成，只要两个s拼接在⼀起，⾥⾯还出现⼀个s的话，就说明是由重复⼦串组成。
    //当然，我们在判断 s + s 拼接的字符串⾥是否出现⼀个s的的时候，要刨除 s + s 的⾸字符和尾字符，这样避免在s+s
    //中搜索出原来的s，我们要搜索的是中间拼接出来的s。
    //时间复杂度: O(n)
    //空间复杂度: O(1)
    //直接 ⽤contains，find 之类的库函数。 却忽略了实现这些函数的时间复杂度（暴⼒解法是m * n，⼀般库函数实现为 O(m + n)）
    public boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
    /*
    KMP算法
    KMP算法中next数组为什么遇到字符不匹配的时候可以找到上⼀个匹配过的位置继续匹配，靠的是有计算好的前缀表。
    前缀表⾥，统计了各个位置为终点字符串的最⻓相同前后缀的⻓度。
    最⻓相同前后缀和重复⼦串的关系⼜有什么关系呢。
    前缀是指不包含最后⼀个字符的所有以第⼀个字符开头的连续⼦串；
    后缀是指不包含第⼀个字符的所有以最后⼀个字符结尾的连续⼦串
    在由重复⼦串组成的字符串中，最⻓相等前后缀不包含的⼦串就是最⼩重复⼦串，这⾥拿字符串s：abababab 来举例，ab就是最⼩重复单位，
     字符串s: a b a b a b a b
最长相等前缀t: 0 1 2 3 4 5
最长相等后缀k:     0 1 2 3 4 5
步骤⼀：因为  这是相等的前缀和后缀，t[0] 与 k[0]相同， t[1] 与 k[1]相同，所以 s[0] ⼀定和 s[2]相同，s[1] ⼀定
和 s[3]相同，即：，s[0]s[1]与s[2]s[3]相同  。
步骤⼆：  因为在同⼀个字符串位置，所以 t[2] 与 k[0]相同，t[3] 与 k[1]相同。
步骤三：  因为  这是相等的前缀和后缀，t[2] 与 k[2]相同  ，t[3]与k[3] 相同，所以，s[2]⼀定和s[4]相同，s[3]⼀定
和s[5]相同，即：s[2]s[3] 与 s[4]s[5]相同。
步骤四：循环往复。
所以字符串s，s[0]s[1]与s[2]s[3]相同， s[2]s[3] 与 s[4]s[5]相同，s[4]s[5] 与 s[6]s[7] 相同。
正是因为  最⻓相等前后缀的规则，当⼀个字符串由重复⼦串组成的，最⻓相等前后缀不包含的⼦串就是最⼩重复⼦串。
     */
    //时间复杂度: O(n)
    //空间复杂度: O(n)
    public boolean repeatedSubstringPattern3(String s) {
        return kmp(s + s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
