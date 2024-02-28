package Java.lebin.Training.InterviewCases.characterString;

/**
 剑指 Offer 67. 把字符串转换成整数
 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
  示例 1:
 输入: "42"
 输出: 42
  */
public class _67_StrToInt_把字符串转换成整数 {
    /*
    复杂度分析：
    时间复杂度 O(N) ： 其中 N 为字符串长度，线性遍历字符串占用 O(N) 时间。
    空间复杂度 O(N) ： 删除首尾空格后需建立新字符串，最差情况下占用 O(N) 额外空间。
     */
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }




    //若不使用 trim() / strip() 方法，而从头开始遍历字符串，则可以将空间复杂度降低至 O(1) ，代码
    public int strToInt2(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }



}
