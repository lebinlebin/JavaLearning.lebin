package Java.lebin.Training.InterviewCases.slidingWindow;
/*
给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
如果不存在这样的子字符串，则返回 0。

示例 1：
输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2：
输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */

public class _395_至少有K个重复字符的最长子串 {
    //分治
    /*
    对于字符串 s，如果存在某个字符 ch，它的出现次数大于 0 且小于 k，则任何包含 ch 的子串都不可能满足要求。
    也就是说，我们将字符串按照 ch 切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。
    因此，可以考虑分治的方式求解本题。
     */
    //时间复杂度：O(N⋅∣Σ∣)，其中 N 为字符串的长度，Σ为字符集
    //空间复杂度：O(∣Σ∣^2)。递归的深度为 O(∣Σ∣)，每层递归需要开辟 O(∣Σ∣)的额外空间。
    public int longestSubstring(String s, int k) {
        // 对于字符串s中的字符t,如果t的个数小于k,那么任何一段
        // 包含t字符的字符串都不会符合,因此按照各个字符t所在的
        // 位置将s砍成几段,再在每一段尝试寻找答案,如此反复即可
        return findMaxLen(s,0,s.length()-1,k);
    }

    private int findMaxLen(String s,int left,int right,int k){
        int[] count = new int[26];
        // 统计这段字符串各个字符个数
        for(int i=left;i<=right;i++){
            count[s.charAt(i)-'a']++;
        }
        char splitChar = 0;
        // 尝试寻找一个字符用于分割字符串
        for(int i=0;i<26;i++){
            // 如果某个字符在这段字符串存在且总个数小于k,那么就以它分割
            if(count[i]>0 && count[i]<k){
                splitChar=(char)(i+'a');
                break;
            }
        }
        // 这时说明这段字符串符合题意
        if(splitChar==0){
            return right-left+1;
        }
        int maxLen = 0;
        int l = left;
        // 将字符串以该字符分割
        while(l<=right){
            // 找到一段不包含分割字符的左边界
            while(l<=right && s.charAt(l)==splitChar){
                l++;
            }
            // 此时说明没有符合的字符串
            if(l>right){
                break;
            }
            // 记录左边界
            int start = l;
            // 往右一直寻找到第一个等于分割字符的右边界
            while(l<=right && s.charAt(l)!=splitChar){
                l++;
            }
            // 对这一段可能满足的字符串继续寻找
            int len = findMaxLen(s,start,l-1,k);
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }

    //时间复杂度：O(N⋅∣Σ∣+∣Σ∣^2)，其中 N 为字符串的长度，Σ 为字符集，本题中字符串仅包含小写字母，因此 ∣Σ∣=26。
    // 我们需要遍历所有可能的 t，共 ∣Σ∣ 种可能性；内层循环中滑动窗口的复杂度为 O(N)，且初始时需要 O(∣Σ∣)的时间初始化 cnt 数组。
    //空间复杂度：O(∣Σ∣)。
    public int longestSubstring2(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
