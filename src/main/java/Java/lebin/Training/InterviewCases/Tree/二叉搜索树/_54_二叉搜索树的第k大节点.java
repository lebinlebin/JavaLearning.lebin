package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 剑指 Offer 54. 二叉搜索树的第k大节点
 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class _54_二叉搜索树的第k大节点 {

    private static List<Integer> arr=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        //中序遍历,正序赋值数组
        inOrder(root);
        //寻找第k大的数，输出
        return arr.get(arr.size()-k);
    }
    //中序遍历
    private static void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);

    }

    /*
    二叉搜索树的中序遍历为 递增序列 。
    根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列 。
    因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。
     */
    //中序遍历 为 “左、根、右” 顺序
    /*
       // 打印中序遍历
        void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.left); // 左
            System.out.println(root.val); // 根
            dfs(root.right); // 右
        }
     */
    //中序遍历的倒序 为 “右、根、左” 顺序
    /*
        // 打印中序遍历倒序
        void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.right); // 右
            System.out.println(root.val); // 根
            dfs(root.left); // 左
        }
     */

    /*
    为求第 k 个节点，需要实现以下 三项工作 ：
    递归遍历时计数，统计当前节点的序号；
    递归到第 k 个节点时，应记录结果 res ；
    记录结果后，后续的遍历即失去意义，应提前终止（即返回）。

    递归解析：
    终止条件： 当节点 root 为空（越过叶节点），则直接返回；
    递归右子树： 即 dfs(root.right)；
    三项工作：
    提前返回： 若 k=0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
    统计序号： 执行k=k−1 （即从 k 减至 0 ）；
    记录结果： 若k=0 ，代表当前节点为第 k 大的节点，因此记录 res = root.val；
    递归左子树： 即 dfs(root.left)；
     */

    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }



}
