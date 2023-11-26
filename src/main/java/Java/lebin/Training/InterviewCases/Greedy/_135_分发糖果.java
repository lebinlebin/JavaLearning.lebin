package Java.lebin.Training.InterviewCases.Greedy;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 示例 1：
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
/*
1. 先确定右边评分大于左边的情况（也就是从前向后遍历）
	此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，
	全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
	局部最优可以推出全局最优。
	如果ratings[i] > ratings[i - 1] 那么[i]的糖 一定要比[i - 1]的糖多一个，所以贪心：candyVec[i] = candyVec[i - 1] + 1

2. 再确定左孩子大于右孩子的情况（从后向前遍历）
	遍历顺序这里有同学可能会有疑问，为什么不能从前向后遍历呢？
	ratings[i]  的糖果确定需要 ratings[i-1]和 ratings[i+1]的比较结果。  ratings[i-1]第一轮遍历已经知道了，
	因为 rating[5]与rating[4]的比较 要利用上 rating[5]与rating[6]的比较结果，所以 要从后向前遍历。
	如果从前向后遍历，rating[5]与rating[4]的比较 就不能用上 rating[5]与rating[6]的比较结果了
	所以确定左孩子大于右孩子的情况一定要从后向前遍历！

如果 ratings[i] > ratings[i + 1]，此时candyVec[i]（第i个小孩的糖果数量）就有两个选择了，一个是candyVec[i + 1] + 1（从右边这个加1得到的糖果数量），
一个是candyVec[i]（之前比较右孩子大于左孩子得到的糖果数量）。
那么又要贪心了，局部最优：取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，保证第i个小孩的糖果数量既大于左边的也大于右边的。
全局最优：相邻的孩子中，评分高的孩子获得更多的糖果。
就取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，candyVec[i]只有取最大的才能既保持对左边candyVec[i - 1]的糖果多，也比右边candyVec[i + 1]的糖果多。
 */
//时间复杂度: O(n)
//空间复杂度: O(n)
public class _135_分发糖果 {
	public int candy(int[] ratings) {
		int[] candyvec = new int[ratings.length];
		//每个孩⼦⾄少分配到1个糖果。
		for(int i=0;i < candyvec.length;i++){
			candyvec[i] = 1;
		}

		//相邻的孩⼦中，评分⾼的孩⼦必须获得更多的糖果。
		//从前往后
		for(int i=1;i<ratings.length;i++){
			if(ratings[i] > ratings[i-1]){ // 右边的大于左边的 那么 candyvec[i] = candyvec[i-1]+1
				candyvec[i] = candyvec[i-1]+1;
			};
		}

		//从后往前
		for(int i = ratings.length-2; i >= 0; i--){
			if(ratings[i] > ratings[i+1]){//左边的大于右边
				candyvec[i] = Math.max(candyvec[i+1]+1,candyvec[i]);//既要大于他的右边，又要大于他的左边。满足两种情况
			};//右边的大于左边的 那么 candyvec[i] = candyvec[i-1]+1
		}
		//统计结果
		int result=0;
		for(int i=0; i < candyvec.length; i++)
			result += candyvec[i];
		return result;
	}
}
