package Java.lebin.Training.InterviewCases.characterString;
/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。

示例 1：
输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：
输入：ransomNote = "aa", magazine = "ab"
输出：false
 */
/*
时间复杂度：O(m+n)，其中 m 是字符串 ransomNote的长度，n 是字符串 magazine的长度，我们只需要遍历两个字符一次即可。
空间复杂度：O(∣S∣)，S 是字符集，这道题中 S 为全部小写英语字母，因此 ∣S∣=26。
 */
public class _383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // shortcut
        // if (ransomNote.length() > magazine.length()) {
        //     return false;
        // }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }
}
