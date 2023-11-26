package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
347. 前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class _347_前K个高频元素 {
	//时间复杂度：O(nlogk).
	// 首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是O(n)；
	// 接着，遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，则将顶部的元素删除并将该元素加入堆中，这里维护堆的数目是 k，所以这一系列操作的时间复杂度是 O(nlogk) 的； 总的时间复杂度是 O(nlogk)。
	//空间复杂度：O(n)，最坏情况下（每个元素都不同），map 需要存储 n 个键值对，优先队列需要存储 k 个元素，因此，空间复杂度是 O(n)。
	//解法1：基于大顶堆实现
	public int[] topKFrequent1(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数

		for(int num:nums){
			map.put(num,map.getOrDefault(num,0)+1);
		}
		//在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
		//出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
		PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair2[1]-pair1[1]);
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){//大顶堆需要对所有元素进行排序
			pq.add(new int[]{entry.getKey(),entry.getValue()});
		}

		int[] ans = new int[k];
		for(int i=0; i<k; i++){//依次从队头弹出k个,就是出现频率前k高的元素
			ans[i] = pq.poll()[0];
		}
		return ans;
	}

	//解法2：基于小顶堆实现
	public int[] topKFrequent2(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
		for(int num:nums){
			map.put(num,map.getOrDefault(num,0)+1);
		}
		//在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
		//出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
		PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){//小顶堆只需要维持k个元素有序
			if(pq.size()<k){//小顶堆元素个数小于k个时直接加
				pq.add(new int[]{entry.getKey(),entry.getValue()});
			}else{
				if(entry.getValue()>pq.peek()[1]){//当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
					pq.poll();//弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
					pq.add(new int[]{entry.getKey(),entry.getValue()});
				}
			}
		}
		int[] ans = new int[k];
		for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
			ans[i] = pq.poll()[0];
		}
		return ans;
	}
}