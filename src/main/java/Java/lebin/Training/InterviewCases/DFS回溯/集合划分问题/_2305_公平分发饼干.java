package Java.lebin.Training.InterviewCases.DFS回溯.集合划分问题;
/*
给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，所有 零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。
分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。
返回所有分发的最小不公平程度。
示例 1：
输入：cookies = [8,15,10,20,8], k = 2
输出：31
解释：一种最优方案是 [8,15,8] 和 [10,20] 。
- 第 1 个孩子分到 [8,15,8] ，总计 8 + 15 + 8 = 31 块饼干。
- 第 2 个孩子分到 [10,20] ，总计 10 + 20 = 30 块饼干。
分发的不公平程度为 max(31,30) = 31 。
可以证明不存在不公平程度小于 31 的分发方案。
示例 2：
输入：cookies = [6,1,3,2,2,4,1,2], k = 3
输出：7
解释：一种最优方案是 [6,1]、[3,2,2] 和 [4,1,2] 。
- 第 1 个孩子分到 [6,1] ，总计 6 + 1 = 7 块饼干。
- 第 2 个孩子分到 [3,2,2] ，总计 3 + 2 + 2 = 7 块饼干。
- 第 3 个孩子分到 [4,1,2] ，总计 4 + 1 + 2 = 7 块饼干。
分发的不公平程度为 max(7,7,7) = 7 。
可以证明不存在不公平程度小于 7 的分发方案。
 */
//时间复杂度：O(k^n)
//空间复杂度：O(k)
public class _2305_公平分发饼干 {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] bucket = new int[k];
        dfs(cookies,bucket,k,0,0);
        return ans;
    }
    public void dfs(int[] cookies,int[] bucket,int k,int index,int max){
        if(index == cookies.length){
            ans = Math.min(ans,max);
            return;
        }
        for(int i =0;i<k;i++){
            bucket[i] += cookies[index];
            dfs(cookies,bucket,k,index+1,Math.max(max,bucket[i]));
            bucket[i] -= cookies[index];
            //剪枝，如果回溯之后变成0，下一次就要放其它空的地方，其实效果是一样的，因为每个人都是等价的
            if(bucket[i] == 0){
                break;
            }
        }
    }
}
