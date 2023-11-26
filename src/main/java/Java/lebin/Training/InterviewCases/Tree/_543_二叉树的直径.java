package Java.lebin.Training.InterviewCases.Tree;

public class _543_二叉树的直径 {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ) return 0;
        calcDepth(root);
        return result-1;
    }
    private  int calcDepth(TreeNode root){
        if(root == null) return 0;
        int L = calcDepth(root.left);
        int R = calcDepth(root.right);
        result = Math.max(result,L+R+1);
        return Math.max(L,R)+1;
    }
}
