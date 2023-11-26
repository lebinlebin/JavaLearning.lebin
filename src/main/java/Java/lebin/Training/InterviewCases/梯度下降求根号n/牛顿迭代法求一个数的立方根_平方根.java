package Java.lebin.Training.InterviewCases.梯度下降求根号n;

/*
// 不调用原有的库函数，求一个数的立方根、平方根 ------牛顿迭代法，不得不说牛顿太伟大了！
我们现在先求平方根： 设函数 f(x) = x^2 - a  ,那么求 a 的平方根等价于求 f(x) = 0 , 由牛顿迭代公式有：
  x = x0 - f(x0)/f `(x0)       ( f `(x) 为函数 f(x)  的一阶导数 f `(x) != 0)
  进行迭代：

 x1 = x0 -f(x0)/f `(x0)
 x2 = x1 - f(x1)/f `(x1)
 x3 = x2 - f(x2)/f `(x2)
 ......
 xk+1 = xk - f(xk)/f `(xk)  (k = 0,1,2,3......)
同样道理，求立方根时 我们设函数 f(x) = x^3 - a,  那么求  a  的立方根等价于求 f(x) = 0
 */
public class 牛顿迭代法求一个数的立方根_平方根 {
    //迭代法求立方根
    public static double getCube(double input){
        double x = 1;
        double x1 = x - (x*x*x - input) / (3*x*x);
        while(x - x1 > 0.000000001 || x - x1 < -0.000000001){		//判断精度
            x = x1;
            x1 = x - (x*x*x - input) / (3*x*x);
        }
        return x1;
    }

    //迭代法求平方根
    public double getSqrt(double input){
        double x = 1;
        double x1 = x - (x*x - input)/(2*x);
        while(x - x1 > 0.00000001 || x - x1 < -0.00000001){
            x = x1;
            x1 = x - (x*x - input)/(2*x);
        }
        return x1;
    }
    public static  void main(String[] args) {
        System.out.println(getCube(2));
    }

}
