package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。

示例1:
输入: pattern = "abba", s = "dog cat cat dog"
输出: true
示例 2:
输入:pattern = "abba", s = "dog cat cat fish"
输出: false
示例 3:
输入: pattern = "aaaa", s = "dog cat cat dog"
输出: false
 */
public class _290_单词规律 {
    public boolean wordPattern(String pattern, String str) {
        int patternLength = pattern.length();
        String[] strArray = str.split(" ");
        if (patternLength != strArray.length) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Set<String> uniqueValue = new HashSet<>();
        char[] patternArray = pattern.toCharArray();
        for (int i = 0; i < patternLength; i++) {
            if (map1.containsKey(patternArray[i])) {
                if (!map1.get(patternArray[i]).equals(strArray[i])) {
                    return false;
                }
            } else {
                if (uniqueValue.contains(strArray[i])) {
                    return false;
                }
                uniqueValue.add(strArray[i]);
                map1.put(patternArray[i], strArray[i]);
            }
        }
        return true;
    }
}
