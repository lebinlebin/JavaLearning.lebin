package Java.lebin.Training.InterviewCases.MathOperator;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 */
/*
递归，自顶向下
 */
public class _50_Pow {
    //--------------------------------------------------------------------------
    //方法二，分而治之。比O(N)更好的算法是O(logN)那么？logN算法特性是，最常见的logN算法就是二分法，每次循环实现计算量减半。
    //计算2^10=2^5*2^5,而2^5又可以利用类似的思路进行分治===>可以利用递归达到分治法，达到每次只计算一半的结果
    //时间复杂度:  T(n) = T(n/2) + O(1) = O(logn)  每次把计算空间缩小一半
    //空间复杂度  O(logn)
    public static double myPow3(double x, int n) {
        long N = n;//当传入的是-2^31时候，我们取负数得到2^31，超过了32整形的最大值，这里转化为long
        if(N==0||x==1){
            return 1;
        }
        if(N < 0){
            return 1/myPowHelper(x,Math.abs(N));
        }
        return myPowHelper(x,N);
    }

    public static double myPowHelper(double x, long n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;

        if(n % 2 != 0){//奇数
            //先求出规模的一半
            double half = myPowHelper(x, n >> 1);
            return  half * half * x;
        }else{//偶数
            double half = myPowHelper(x, n >> 1);
            return  half * half;
        }
    }


    //---------------------------------------------------------------------------------------------------
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;

        //先求出规模的一半
        double half = myPow(x, n >> 1);
        //右移一位。不管是奇数还是偶数右移一位都会获得原规模的一半
        // 21右移一位为10，20右移一位也为10
        half *= half;
        // 是否为奇数
        //最小的二进制位为1的话为奇数，否则为偶数
        //                        奇数       偶数
        return ((n & 1) == 1) ? (half * x) : half;
        /**
         * 这里正数负数做了统一
         * 当n为负数有两种情况
         * 1）n为负数且为偶数，那么n >> 1与n/2等价
         * 2）n为负数且为奇数，那么 n>>1 与n/2不等价，(n>>1)*n = n/2
         */
    }

    public static double myPow(double x, int n) {
        //-2^31 <= n <= 2^(31)-1
        //当传入的是-2^31时候，我们取负数得到2^31，超过了32整形的最大值，这里转化为long
        long y = (n < 0) ? -((long) n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制位是1，就累乘上x
                res *= x;
            }
            x *= x;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return (n < 0) ? (1 / res) : res;
    }

    //-----------------方法二自底向上 把指数看成二进制形式----------------------------------------------------------------------------------
    //时间复杂度：O(logn)
    public double myPow4(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        double res = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return res;
    }

    //暴力解法
    //时间复杂度 O(n)
    //空间复杂度O(1)
    public static double myPow1(double x, int n) {
        long  N = n;
        if(N<0){
            x = 1/x;
            N=-N;
        }
        double ans = 1;
        for(long i=0;i<N;i++){
            ans = ans * x;
        }
        return ans;
    }


    public static void main(String[] args) {
//        System.out.println(powMod1(-123, 455, 789));
//        System.out.println(powMod(-123, 455, 789));
    }
}
