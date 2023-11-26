package Java.lebin.Training.InterviewCases.Tree.层序遍历;

/**
 * 559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 */

//可以发现想要翻转它，其实就把每⼀个节点的左右孩⼦交换⼀下就可以了。
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int count = root.children.size();
        int max = 0;
        //这里进入递归
        for (int i = 0; i < count; i++) {
            max = Math.max(maxDepth(root.children.get(i)),max);
        }
        return max+1;
    }
}
