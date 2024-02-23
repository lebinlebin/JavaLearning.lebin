package Java.lebin.Training.InterviewCases;

public class 时间复杂度分析 {

    //O(n)
    public  static  int function1(int x, int n) {
        int result = 1;  // 注意 任何数的0次方等于1
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }
    ///O(n)
    public  static  int function2(int x, int n) {
        if (n == 0) {
            return 1; // return 1 同样是因为0次方是等于1的
        }
        return function2(x, n - 1) * x;
    }
    //O(n)
    public  static  int function3(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n % 2 == 1) {
            return function3(x, n / 2) * function3(x, n / 2)*x;
        }
        return function3(x, n / 2) * function3(x, n / 2);
    }

    //O(logn)
    public  static  int function4(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int t = function4(x, n / 2);// 这里相对于function3，是把这个递归操作抽取出来
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }

    public static void main(String[] args) {
        System.out.println(function4(4,4));
    }
}

