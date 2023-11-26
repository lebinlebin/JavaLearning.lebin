package Java.lebin.Training.InterviewCases.Tree.层序遍历;

public class NodeForNext {
    public int val;
    public NodeForNext left;
    public NodeForNext right;
    public NodeForNext next;

    public NodeForNext() {}

    public NodeForNext(int _val) {
        val = _val;
    }

    public NodeForNext(int _val, NodeForNext _left, NodeForNext _right, NodeForNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}