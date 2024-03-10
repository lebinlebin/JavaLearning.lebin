package Java.lebin.Training.InterviewCases.优先队列;

import java.util.*;

/*
城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。

每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：

lefti 是第 i 座建筑物左边缘的 x 坐标。
righti 是第 i 座建筑物右边缘的 x 坐标。
heighti 是第 i 座建筑物的高度。
你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。

天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]

示例 1：
输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
解释：
图 A 显示输入的所有建筑物的位置和高度，
图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
示例 2：

输入：buildings = [[0,2,3],[2,5,3]]
输出：[[0,3],[5,0]]
 */
public class _218_天际线问题 {
    //时间复杂度：O(NlogN)，这里N 是输入数组的长度。
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 第 1 步：预处理
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            // 负号表示左边高度的转折点
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }

        // 第 2 步：按照横坐标排序，横坐标相同的时候，高度高的在前面
        buildingPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                // 注意：这里因为左端点传进去的时候，数值是负的，在比较的时候还按照升序排序
                return a[1] - b[1];
            }
        });

        // 第 3 步：扫描一遍动态计算出结果
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
        Map<Integer, Integer> delayed = new HashMap<>();

        // 最开始的时候，需要产生高度差，所以需要加上一个高度为 0，宽度为 0 的矩形
        maxHeap.offer(0);
        // 为了计算高度差，需要保存之前最高的高度
        int lastHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] buildingPoint : buildingPoints) {
            if (buildingPoint[1] < 0) {
                // 说明此时是「从下到上」，纵坐标参与选拔最大值，请见「规则 1」
                maxHeap.offer(-buildingPoint[1]);
            } else {
                // 不是真的删除 buildingPoint[1]，把它放进 delayed，等到堆顶元素是 buildingPoint[1] 的时候，才真的删除
                delayed.put(buildingPoint[1], delayed.getOrDefault(buildingPoint[1], 0) + 1);
            }

            // 如果堆顶元素在延迟删除集合中，才真正删除，这一步可能执行多次，所以放在 while 中
            // while (true) 都是可以的，因为 maxHeap 一定不会为空
            while (!maxHeap.isEmpty()) {
                int curHeight = maxHeap.peek();
                if (delayed.containsKey(curHeight)) {
                    delayed.put(curHeight, delayed.get(curHeight) - 1);
                    if (delayed.get(curHeight) == 0) {
                        delayed.remove(curHeight);
                    }
                    maxHeap.poll();
                } else {
                    break;
                }
            }

            int curHeight = maxHeap.peek();
            // 有高度差，才有关键点出现
            if (curHeight != lastHeight) {
                // 正在扫过的左端点的值
                res.add(Arrays.asList(buildingPoint[0], curHeight));
                // 当前高度成为计算高度差的标准
                lastHeight = curHeight;
            }
        }
        return res;
    }
}
