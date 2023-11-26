package Java.lebin.Training.InterviewCases.DP.背包问题;
/*
01 背包
有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
/*
1. dp定义
    对于背包问题，有一种写法， 是使用二维数组，即dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
2. 递推公式
    根据放不放物品i，得到递推公式，
    1) 不放物品i：由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]。(其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以背包内的价值依然和前面相同。)
    2) 放物品i：由dp[i - 1][j - weight[i]]推出，dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
    那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
    所以递归公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
3. 初始化
    dp[i][0]，无论是选取哪些物品，因为背包容量为0，背包价值总和一定为0。
    dp[0][j]，即：i为0，存放编号0的物品的时候，各个容量的背包所能存放的最大价值。
    当 j < weight[0]的时候，dp[0][j] 应该是 0，因为背包容量比编号0的物品重量还小。
    当j >= weight[0]时，dp[0][j] 应该是value[0]，因为背包容量放足够放编号0物品。
4.遍历顺序
   有两个遍历的维度：物品与背包重量
   先遍历 物品还是先遍历背包重量呢？其实都可以！！ 但是先遍历物品更好理解。

 */
public class _01_背包问题和DP数组压缩 {
    /**
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];//dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。

        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];//j <= bagSize时候价值就是value[0]，j超过bagSize  价值为0
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    //当前背包的容量 < 当前物品i，不放物品i
                    //那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                    dp[i][j] = dp[i-1][j];
                } else {
                    //当前背包的容量可以放下物品i
                    //那么此时分两种情况： 1、不放物品i  2、放物品i; 比较这两种情况下，哪种背包中物品的最大价值最大
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }


    //01背包理论基础（滚动数组）压缩dp数组到1维
    //说明状态是可以压缩的
    public static void testWeightBagProblem1D(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){//倒序遍历是为了保证物品i只被放入一次！
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem1D(weight,value,bagSize);
    }
}
