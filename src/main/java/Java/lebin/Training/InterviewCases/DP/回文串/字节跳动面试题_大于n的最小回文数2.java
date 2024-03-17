package Java.lebin.Training.InterviewCases.DP.回文串;

public class 字节跳动面试题_大于n的最小回文数2 {
    public static void main(String[] args) {
        long n = 12345; // 可以替换为任何你想要找的数字
        long nextPalindrome = findNextPalindromeOptimized(n);
        System.out.println("大于 " + n + " 的最小回文数是: " + nextPalindrome);
    }

    public static long findNextPalindromeOptimized(long n) {
        String s = Long.toString(n);
        int len = s.length();
        char[] chars = s.toCharArray();

        // 处理长度为奇数的情况
        if (len % 2 != 0) {
            chars[len / 2] = '0'; // 将中间位设为0，以便处理镜像
            len++; // 长度增加1，因为我们现在有一个额外的0在中间
        }

        // 分成两半
        int halfLen = len / 2;
        String firstHalf = new String(chars, 0, halfLen);

        // 找到大于firstHalf的最小回文数的前半部分
        String nextFirstHalf = findNextPalindromeHalf(firstHalf);

        // 构建完整的回文数
        StringBuilder sb = new StringBuilder(nextFirstHalf);
        sb.append(new StringBuilder(nextFirstHalf).reverse().toString());

        // 转换回长整型并检查是否大于原数n
        long candidate = Long.parseLong(sb.toString());
        return candidate > n ? candidate : findNextPalindromeOptimized(candidate);
    }

    private static String findNextPalindromeHalf(String firstHalf) {
        String reversed = new StringBuilder(firstHalf).reverse().toString();
        if (firstHalf.compareTo(reversed) < 0) {
            // 如果前半部分小于它的反转，我们只需要增加前半部分
            return incrementString(firstHalf);
        } else {
            // 如果前半部分大于或等于它的反转，那么firstHalf已经是一个回文数的前半部分。
            // 在这种情况下，我们需要找到一个更大的回文数，这可以通过在前半部分的最后一位加1来实现。
            // 但是，如果最后一位是9，我们需要递归地处理进位。
            return incrementStringWithCarry(firstHalf);
        }
    }

    private static String incrementString(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        while (i >= 0 && chars[i] == '9') {
            chars[i] = '0';
            i--;
        }
        if (i >= 0) {
            chars[i]++;
        } else {
            // 如果整个字符串都是9，那么我们需要在前面添加一个1，并填充其余的0。
            // 例如，"999" 变成 "1000"
            char[] newChars = new char[chars.length + 1];
            newChars[0] = '1';
            for (int j = 1; j < newChars.length; j++) {
                newChars[j] = '0';
            }
            return new String(newChars);
        }
        return new String(chars);
    }

    // 这个方法实际上和incrementString相同，但是为了清晰起见，我在这里保留了两个方法。
    // 在实践中，你可以只使用incrementString方法。
    private static String incrementStringWithCarry(String s) {
        return incrementString(s);
    }
}


