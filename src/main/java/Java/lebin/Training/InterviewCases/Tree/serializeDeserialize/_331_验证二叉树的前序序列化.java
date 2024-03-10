package Java.lebin.Training.InterviewCases.Tree.serializeDeserialize;

import java.util.ArrayDeque;
import java.util.Deque;

/*
序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
你可以认为输入格式总是有效的
例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

 */
public class _331_验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {
        String[] splits = preorder.split(",");
        int len = splits.length;

        // 特判
        if (len == 1 && "#".equals(splits[0])) {
            return true;
        }

        // 因为空子树需要表示
        if (len < 3) {
            return false;
        }

        // 还没想清楚
        if (!"#".equals(splits[len - 1]) && !"#".equals(splits[len - 2])) {
            return false;
        }

        Deque<String> stack = new ArrayDeque<>();
        stack.push(splits[0]);

        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && "#".equals(stack.peekLast())) {
                stack.removeLast();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
            stack.addLast(splits[i]);
        }
        return !stack.isEmpty() && "#".equals(stack.peekLast());
    }
}
