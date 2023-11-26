package Java.lebin.Training.InterviewCases.DFS回溯.组合问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class _17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();

        if (digits.length() == 0) {
            return res;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        StringBuffer track = new StringBuffer();
        backtrack(res, phoneMap, digits, 0, track);
        return res;
    }

    public void backtrack(List<String> res, Map<Character, String> phoneMap, String digits, int startIndex, StringBuffer track) {
        //终止条件
        if (startIndex == digits.length()) {
            res.add(track.toString());
        } else {
            char digit = digits.charAt(startIndex);
            //获得所有可能的选择
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            //遍历所有可能的选择
            for (int i = 0; i < lettersCount; i++) {
                //做选择
                track.append(letters.charAt(i));
                //回溯进入下一层
                backtrack(res, phoneMap, digits, startIndex + 1, track);
                //撤销选择
                track.deleteCharAt(startIndex);
            }
        }
    }
}
