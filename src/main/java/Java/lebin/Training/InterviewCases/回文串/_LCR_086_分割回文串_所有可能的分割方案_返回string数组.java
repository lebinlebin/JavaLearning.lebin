package Java.lebin.Training.InterviewCases.回文串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。

示例 1：
输入：s = "google"
输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
示例 2：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 3：

输入：s = "a"
输出：[["a"]]

提示：
1 <= s.length <= 16
s 仅由小写英文字母组成
 */
/*
时间复杂度：O(n⋅2^n)，其中 n 是字符串 s 的长度。在最坏情况下，s 包含 n 个完全相同的字符，因此它的任意一种划分方法都满足要求。而长度为 n 的字符串的划分方案数为 2^{n-1}=O(2^n)，
每一种划分方法需要 O(n) 的时间求出对应的划分结果并放入答案，因此总时间复杂度为 O(n⋅2^n)。尽管动态规划预处理需要 O(n^2)的时间，但在渐进意义下小于 O(n⋅2^n)，因此可以忽略。
空间复杂度：O(n^2)，这里不计算返回答案占用的空间。数组 f 需要使用的空间为O(n^2)，而在回溯的过程中，我们需要使用 O(n)的栈空间以及 O(n)的用来存储当前字符串分割方法的空间。
由于 O(n)在渐进意义下小于O(n^2)，因此空间复杂度为O(n^2)。
 */
public class _LCR_086_分割回文串_所有可能的分割方案_返回string数组 {
    //方法一：回溯 + 动态规划预处理
    boolean[][] DP;
    List<List<String>> tmp = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public String[][] partition(String s) {
        n = s.length();
        DP = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(DP[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                DP[i][j] = (s.charAt(i) == s.charAt(j)) && DP[i + 1][j - 1];
            }
        }

        dfs(s, 0);

        int rows = tmp.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = tmp.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = tmp.get(i).get(j);
            }
        }
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            tmp.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (DP[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }













//==================================================================================
    List<List<String>> res = new LinkedList<>();
    List<String>  track = new LinkedList<>();

    public String[][] partition2(String s) {
        backtracking2(s,0);
        String[][] result = convertListTo2DArray(res);
        return result;
    }
    void backtracking2 (String s, int startIndex) {
        // 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        //这里一定是 >= s.length()
        if (startIndex >= s.length()) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //做选择
            if (isPalindrome2(s, startIndex, i)) {   // 是回文子串
                // 获取[startIndex,i]在s中的子串
                String str = s.substring(startIndex, i+1);
                track.add(str);
            } else {                                // 不是回文，跳过
                continue;
            }
            //回溯
            backtracking2(s,i + 1); // 寻找i+1为起始位置的子串
            //撤销选择
            track.remove(track.size()-1); // 回溯过程，弹出本次已经填在的子串
        }

    }

    boolean isPalindrome2(String s, int start, int end) {
        char[] ss = s.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            if (ss[i] != ss[j]) {
                return false;
            }
        }
        return true;
    }

    public static String[][] convertListTo2DArray(List<List<String>> listOfLists) {
        int size = listOfLists.size();
        int maxSize = 0;

        // 确定二维数组中最大子数组的长度
        for (List<String> list : listOfLists) {
            if (list.size() > maxSize) {
                maxSize = list.size();
            }
        }

        // 初始化二维数组
        String[][] array = new String[size][maxSize];

        // 填充二维数组
        for (int i = 0; i < size; i++) {
            List<String> list = listOfLists.get(i);
            for (int j = 0; j < list.size(); j++) {
                array[i][j] = list.get(j);
            }
        }

        return array;
    }

}
