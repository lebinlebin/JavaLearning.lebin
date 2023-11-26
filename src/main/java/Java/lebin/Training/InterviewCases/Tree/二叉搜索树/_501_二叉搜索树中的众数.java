package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
501.二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class _501_二叉搜索树中的众数 {

    //===============================================================================
    //中序遍历-不使用额外空间，利用二叉搜索树特性
    ArrayList<Integer> resList;//结果数组
    int maxCount;// 最大频率
    int count;// 统计频率
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode cur) {
        if (cur == null) {
            return;
        }
        findMode1(cur.left);// 左
        // 中
        int rootValue = cur.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;// 第一个节点或者 与前一个节点数值不同
        } else { // 与前一个节点数值相同
            count++;
        }
        pre = cur;// 更新上一个节点

        if (count == maxCount) {// 如果和最大值相同，放进result中
            resList.add(rootValue);
        }

        // 更新结果以及maxCount
        if (count > maxCount) {// 如果计数大于最大值频率
            maxCount = count;// 更新最大频率
            resList.clear();// 很关键的一步，不要忘记清空result，之前result里的元素都失效了
            resList.add(rootValue);
        }
        findMode1(cur.right);
    }

    //如果不是二叉搜索树。 最直观的方法一定是把这个树都遍历了，用map统计频率，把频率排个序，最后取前面高频的元素的集合。
    public int[] findMode2(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list.stream().mapToInt(Integer::intValue).toArray();
        // 获得频率 Map
        searchBST(root, map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        // 把频率最高的加入 list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void searchBST(TreeNode curr, Map<Integer, Integer> map) {
        if (curr == null) return;
        map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        searchBST(curr.left, map);
        searchBST(curr.right, map);
    }
}
