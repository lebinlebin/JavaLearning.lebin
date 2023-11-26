package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
/*
这里的局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优就是喂饱尽可能多的小孩。

可以尝试使用贪心策略，先将饼干数组和小孩数组排序。
然后从后向前遍历小孩数组，用大饼干优先满足胃口大的，并统计满足小孩数量。
 */
public class _455_分发饼干 {
	/*
	时间复杂度：O(nlogn)
	空间复杂度：O(1)
	 */
	public int findContentChildren(int[] g, int[] s) {
		if(s == null||s.length==0) return 0;
		Arrays.sort(g);//胃口
		Arrays.sort(s);//饼干大小
		int cookieIndex = s.length-1;
		int result = 0;
		//一定是循环的胃口的数据，不能循环饼干的数组
		for(int i = g.length-1; i>=0; i--){
			if(cookieIndex >=0 && g[i] <= s[cookieIndex]){
				result++;
				cookieIndex--;
			}
		}
		return result;
	}
}
