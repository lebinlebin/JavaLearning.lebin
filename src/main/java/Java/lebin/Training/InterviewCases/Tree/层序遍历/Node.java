package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.List;

/**
 * N叉树节点的定义
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
