package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定两个字符串 s 和 t ，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

示例 1:
输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false

 */
/*
重点：建立映射关系的时候，要检查两个 key 是否对应到同一个 value 上了；
越是简单的问题，越有小陷阱；
测试用例：输入："ab"、"aa"，输出：false。
 */
public class _205_同构字符串 {
    /*思路分析
重点：建立映射关系的时候，要检查两个 key 是否对应到同一个 value 上了；
越是简单的问题，越有小陷阱；
测试用例：输入："ab"、"aa"，输出：false。
     */
    /*
    时间复杂度：O(n)，其中 n 为字符串的长度。我们只需同时遍历一遍字符串 s 和 t 即可。
    空间复杂度：O(∣Σ∣)，其中 Σ 是字符串的字符集。哈希表存储字符的空间取决于字符串的字符集大小，
    最坏情况下每个字符均不相同，需要 O(∣Σ∣)的空间。
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        Character curS;
        Character curT;
        for (int i = 0; i < n; i++) {
            curS = s.charAt(i);
            curT = t.charAt(i);
            if (map.containsKey(curS)) {
                if (!curT.equals(map.get(curS))) {
                    return false;
                }
            } else {
                if (set.contains(curT)) {
                    return false;
                } else {
                    set.add(curT);
                    map.put(curS, curT);
                }
            }
        }
        return true;
    }
    /*
    时间复杂度：O(n)，其中 n 为字符串的长度。我们只需同时遍历一遍字符串 s 和 t 即可。
    空间复杂度：O(∣Σ∣)，其中 Σ 是字符串的字符集。哈希表存储字符的空间取决于字符串的字符集大小，
    最坏情况下每个字符均不相同，需要 O(∣Σ∣)O的空间。
     */
    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

}
