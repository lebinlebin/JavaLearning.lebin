package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
class _22_括号生成 {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder track = new StringBuilder();
        backtrack(res, track, 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder track, int left, int right, int n_pair) {

        //终止
        if (track.length() == n_pair * 2) {
            res.add(track.toString());
            return;
        }
        /*
        括号问题的两个重要思路:
        1) 一个合法的括号组合，左括号数量一定等于右括号数量
        2）对于一个合法的括号字符串组合p，必然对于任意 0<=i<len(p)都有：
           子串p[0...i] 中左括号的数量都大于等于右括号的数量
         */
        //做选择
        //左括号还有名额
        if (left < n_pair) {
            //做选择
            track.append('(');
            //对所有的选择进行遍历
            backtrack(res, track, left + 1, right, n_pair);
            //取消选择
            track.deleteCharAt(track.length() - 1);
        }
        //右括号还有名额
        if (right < left) {
            //做选择
            track.append(')');
            //对所有的选择进行遍历
            backtrack(res, track, left, right + 1, n_pair);
            //取消选择
            track.deleteCharAt(track.length() - 1);
        }

    }
}