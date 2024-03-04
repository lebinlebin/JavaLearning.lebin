package Java.lebin.Training.InterviewCases.各种k个数;

import java.util.*;

public class 合并K个有序数组byPriorityQueue {
    static class Node implements Comparator<Node> {
        public int value;//取值大小
        public int arrayIdx;//在哪个数组中
        public int idx;//在该数组中的哪个位置

        public Node() {}
        //value权值大小，arraysIdx在哪个数组里，idx在该数组的哪个位置> >
        public Node(int value, int arrayIdx, int idx) {
            this.value = value;
            this.arrayIdx = arrayIdx;
            this.idx = idx;
        }

        public int compare(Node n1, Node n2) {
            if(n1.value < n2.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    static Comparator<Node> cNode = new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    };
    /*
     复杂度分析
	 时间复杂度：考虑优先队列中的元素不超过 k 个，那么插入和删除的时间代价为 O(logk)，这里最多有 kn 个点，
	 对于每个点都被插入删除各一次，故总的时间代价即渐进时间复杂度为 O(kn×logk)。
	 空间复杂度：这里用了优先队列，优先队列中的元素不超过 k个，故渐进空间复杂度为 O(k)。
     */
    public static  int[] mergekSortedArrays(int[][] arrays) {
        // 初始化 优先队列 ，优先队列的一个元素包括三个值 ：数字大小，数字在哪个数组里，数字在数组的哪个位置
        PriorityQueue<Node> q = new PriorityQueue<Node>(arrays.length, cNode);
        // 初始化 答案
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < arrays.length; i++) {//先把k个数组的第一个元素压入优先级队列
            // 如果这个数组为空 则不用压入
            if(arrays[i].length == 0) {
                continue;
            }
            // arrays[i][0] 权值大小  i 在第i个数组   0 在该数组的0位置
            q.add(new Node(arrays[i][0], i, 0));
        }

        while(!q.isEmpty()) {
            // 取出队列中最小值
            Node point = q.poll();

            // 权值 ，所在数组的编号，在该数组的位置编号
            int value = point.value;
            int arrayIdx = point.arrayIdx;
            int idx = point.idx;

            //  更新答案数组
            ans.add(value);

            // 它已经是所在数组的最后一个元素了，这个数组的所有元素都已经处理完毕
            if(idx == arrays[arrayIdx].length - 1) {
                continue;
            } else {
                // 压入它下一个位置的新元素
                Node newPoint = new Node(arrays[arrayIdx][idx + 1], arrayIdx, idx + 1);
                q.add(newPoint);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6};
        int[] arr2 = {1,2,5,7};
        int[] arr3 = {3,6,9,11};
        int[] arr4 = {5,7,13,17};
        int[][] arrays = {arr1,arr2,arr3,arr4};
        int[] merge1 = mergekSortedArrays(arrays);
//        int[] merge2 = merge(arr3, arr4);
//        int[] merge = merge(merge1, merge2);
        System.out.println(Arrays.toString(merge1));
    }
}
