package Java.lebin.Training.InterviewCases.DP.回文串;

public class 字节跳动面试题_大于n的最小回文数 {
    public static void main(String[] args) {
        int n = 132;  // 你可以更改这个值进行测试
        int nextPalindrome1 = getNextPalindrome(n);
        int nextPalindrome2 = helper(n);
        System.out.println("大于 " + n + " 的最小回文数是: " + nextPalindrome1);
        System.out.println("大于 " + n + " 的最小回文数是: " + nextPalindrome2);

    }

    public static int getNextPalindrome(int n) {
        while (true) {
            n++;
            if (isPalindrome(n)) {
                return n;
            }
        }
    }

    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    /*
    分情况只需要考虑n的位数是奇数还是偶数就可以，
    思路就是分别取出前半部分、后半部分，然后比较大小，前半部分大于后半部分的话
    前半部分直接翻转拼接，否则前半部分先+1再翻转拼接即可
     */
    public static int helper(int n){
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        int digit = sb.length();
        boolean flag = digit % 2 == 1;
        int pre, tail;
        if(flag){
            pre = Integer.parseInt(sb.substring(0, digit / 2 + 1));
            tail  = Integer.parseInt(sb.reverse().substring(0, digit / 2 + 1));
        }else{
            pre = Integer.parseInt(sb.substring(0, digit / 2));
            tail  = Integer.parseInt(sb.reverse().substring(0, digit / 2));
        }
        StringBuilder ans = new StringBuilder(), preReverse = new StringBuilder(String.valueOf(pre)).reverse();
        if(pre <= tail || Integer.parseInt(preReverse.toString()) <= tail ){
            int len1 = String.valueOf(pre).length();
            pre++;
            int len2 = String.valueOf(pre).length();
            if(len2 > len1) {
                if(flag){
                    pre /= 10;
                }
                flag = !flag;
            }
        }
        ans.append(pre);
        //此处不能直接ans.append(ans.reverse())会导致ans整个翻转，需要临时变量temp
        StringBuilder temp = new StringBuilder(String.valueOf(pre)).reverse();
        ans.append(temp);
        if(flag) ans.deleteCharAt(digit / 2);
        return Integer.parseInt(ans.toString());
    }

}