package Java.lebin.Training.InterviewCases.MathOperator;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 剑指 Offer 41. 数据流中的中位数
 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 例如，

 [2,3,4] 的中位数是 3

 [2,3] 的中位数是 (2 + 3) / 2 = 2.5

 设计一个支持以下两种操作的数据结构：

 void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 double findMedian() - 返回目前所有元素的中位数。
 示例 1：

 输入：
 ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 [[],[1],[2],[],[3],[]]
 输出：[null,null,null,1.50000,null,2.00000]
 示例 2：

 输入：
 ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 [[],[2],[],[3],[]]
 输出：[null,null,2.00000,null,2.50000]
 */
public class 剑指Offer41_数据流中的中位数 {
}

class MedianFinder {
    Queue<Integer> minHeap_high, maxHeap_low;
    public MedianFinder() {

        minHeap_high = new PriorityQueue<>(); // 小顶堆，保存较大的一半

        maxHeap_low = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        //奇数
        if(minHeap_high.size() != maxHeap_low.size()) {
            //为什么要先放到minHeap_high
            minHeap_high.add(num);
            maxHeap_low.add(minHeap_high.poll());//将最小的拿出一个，放到low里面
        } else {
            //偶数
            maxHeap_low.add(num);
            minHeap_high.add(maxHeap_low.poll());
        }
    }
    public double findMedian() {
        return minHeap_high.size() != maxHeap_low.size() ? minHeap_high.peek() : (minHeap_high.peek() + maxHeap_low.peek()) / 2.0;
    }
}