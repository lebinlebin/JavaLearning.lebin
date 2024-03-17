package Java.lebin.Training.InterviewCases.characterString;
/*
算法：判断一个字符串最多只删1个字符，是否能成为一个回文字符串。
扩展  如果要返回最长的部分呢？
 */
public class _LCR019_验证回文串II_删除一个字符使之成为回文串 {
    //时间复杂度：O(n)，其中 n 是字符串的长度。判断整个字符串是否是回文字符串的时间复杂度是 O(n)，
    // 遇到不同字符时，判断两个子串是否是回文字符串的时间复杂度也都是O(n)。
    //空间复杂度：O(1)。只需要维护有限的常量空间。
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 尝试跳过左边或右边的字符，看剩下的部分是否是回文
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        // 如果没有遇到需要删除的字符，整个字符串已经是回文
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abcba"));  // 输出: true
        System.out.println(validPalindrome("abcca"));  // 输出: true
        System.out.println(validPalindrome("abc"));    // 输出: false
        System.out.println(validPalindrome("a"));    // 输出: false

    }
}