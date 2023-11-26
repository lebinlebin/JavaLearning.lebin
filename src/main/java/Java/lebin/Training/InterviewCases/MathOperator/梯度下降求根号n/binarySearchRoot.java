package Java.lebin.Training.InterviewCases.MathOperator.梯度下降求根号n;

public class binarySearchRoot {
    //给一个实数x, 求x的五次方根
    public static double binarySearchRoot(double x) {
        double low = 0;
        double high = 0;
        //判断是否是小数，low和high需要有不同的区间
        if(x >= 1 ){
            low = 0;
            high = x;
        }else if(x <= -1){
            high = 0;
            low = x;
        }else if(x > -1 && x <0){//-1~0之间
            high = x;
            low = -1;
        }else if(x > 0 && x <1){//0~1之间
            high = 1;
            low = x;
        }

        double eps = 0.000001;
        while(high - low > eps){
            double mid = (low + high)/2;
            double midPow5 = Math.pow(mid,5);
            if(midPow5 > x){
                high = mid;
            }else {
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        double res = binarySearchRoot(0.1);
        System.out.println(res);
    }
}
