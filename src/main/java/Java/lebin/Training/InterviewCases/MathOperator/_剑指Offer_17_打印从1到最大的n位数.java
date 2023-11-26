package Java.lebin.Training.InterviewCases.MathOperator;

/**
 剑指 Offer 17. 打印从1到最大的n位数
 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 示例 1:
 输入: n = 1
 输出: [1,2,3,4,5,6,7,8,9]
 */
public class _剑指Offer_17_打印从1到最大的n位数 {

    public static void printNumbers(int n) {
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }

        //只要不溢出就打印
        while(!increment(str)){
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0'){
                index++;
            }
            System.out.println(str.toString().substring(index));
        }
    }


    /*
    java.lang.StringBuilder.replace()方法用指定String中的字符替换此序列的子字符串中的字符。
    子字符串从指定的开始处start并延伸到索引end - 1处的字符end - 1或如果不存在此类字符则延伸到序列的结尾。
     */
    public static boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        //从后往前
        for (int i = str.length() - 1; i >= 0; i--) {

            char s = (char)(str.charAt(i) + 1);
            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                //直到字符数组的最左边第0位为止，溢出。
                if (i == 0) {
                    isOverflow = true;
                }
            }
            // 没发生进位则跳出for循环
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }




    public static void main(String[] args) {
        printNumbers(6);
    }
}
