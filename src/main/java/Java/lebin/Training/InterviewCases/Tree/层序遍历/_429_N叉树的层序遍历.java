package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
//这道题依旧是模板题，只不过一个节点有多个孩子了
public class _429_N叉树的层序遍历 {
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new LinkedList<>();
        LinkedList<List<Integer>> res = new  LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            //也可以用for循环
            for (int i = 0; i < count; i++) {
                Node cur = queue.poll();
                list.add(cur.val);
                for(Node node:cur.children){
                    queue.add(node);
                }
            }
            res.add(list);
        }
        return res;
    }
}
