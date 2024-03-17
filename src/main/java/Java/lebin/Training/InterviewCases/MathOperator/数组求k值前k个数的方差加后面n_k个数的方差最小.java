package Java.lebin.Training.InterviewCases.MathOperator;
/*
问题：给你一个数组，求一个k值，使得前k个数的方差 + 后面n-k个数的方差最小 ，时间复杂度为o(n)。
思路：申明两个数组分别用来存储从左侧开始计算的方差，和从右侧开始计算的方差，最后将两个数组错一位相加，取和值最小的位点返回。
 */
public class 数组求k值前k个数的方差加后面n_k个数的方差最小 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 示例数组
        int k = findBestK(nums); // 找到近似的k值
        System.out.println("Best k: " + k); // 输出结果
    }

    public static int findBestK(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1]; // 前缀和数组，prefixSum[i]表示nums[0]到nums[i-1]的和
        long[] prefixSquareSum = new long[n + 1]; // 前缀平方和数组，prefixSquareSum[i]表示nums[0]^2到nums[i-1]^2的和
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1]; // 计算前缀和
            prefixSquareSum[i] = prefixSquareSum[i - 1] + (long) nums[i - 1] * nums[i - 1]; // 计算前缀平方和
        }

        long minVarianceSum = Long.MAX_VALUE; // 存储最小的方差和
        int bestK = -1; // 存储最佳的k值

        for (int k = 1; k < n; k++) { // 遍历所有可能的k值（除了0和n，因为这两种情况没有意义）
            long sum1 = prefixSum[k]; // 前k个数的和
            long sum2 = prefixSum[n] - sum1; // 后面n-k个数的和
            long squareSum1 = prefixSquareSum[k]; // 前k个数的平方和
            long squareSum2 = prefixSquareSum[n] - squareSum1; // 后面n-k个数的平方和

            long count1 = k; // 前k个数的数量
            long count2 = n - k; // 后面n-k个数的数量

            if (count2 == 0) continue; // 避免除以0的情况

            double mean1 = (double) sum1 / count1; // 前k个数的平均值
            double mean2 = (double) sum2 / count2; // 后面n-k个数的平均值

            // 计算方差和（注意这里我们实际上计算的是方差乘以数量，以避免多次计算平均值）
            long varianceSum = (long) (count1 * (mean1 * mean1 * count1 - 2 * mean1 * sum1 + squareSum1) +
                    count2 * (mean2 * mean2 * count2 - 2 * mean2 * sum2 + squareSum2));

            // 如果找到了更小的方差和，则更新最佳的k值和最小的方差和
            if (varianceSum < minVarianceSum) {
                minVarianceSum = varianceSum;
                bestK = k;
            }
        }

        return bestK; // 返回最佳的k值（注意这里可能返回-1，表示没有找到有效的k值）
    }
}
