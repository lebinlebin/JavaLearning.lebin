package Java.lebin.Training.InterviewCases.sort;

import java.util.*;

/*
给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
示例 1:
输入: s = "tree"
输出: "eert"
解释: 'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:
输入: s = "cccaaa"
输出: "cccaaa"
解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
提示:
1 <= s.length <= 5 * 105
s 由大小写英文字母和数字组成
 */

public class _451_根据字符出现频率排序 {
    /*
    三路快排（本题主要想考查的）
注意到题目中的说明： s 由大小写英文字母和数字组成。所以 s 的种类是有限的，有
26×2+10=36种，而 s 的长度最大是5*10^5，因此 s 中有大量重复的值，这一点提示我们可以使用「三路快排」，
代码其实和「三路快排」是一样的，在编码的时候清楚变量的定义就容易写对；
下面两版代码的不同只是在于循环不变量的定义（已经作为注释写在代码中），读者只需要实现任意一种。
     */
    private final static Random random = new Random(System.currentTimeMillis());

    private int[] freq;

    public String frequencySort(String s) {
        freq = new int[128];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            freq[c]++;
        }

        quickSort(charArray, 0, s.length() - 1);
        return new String(charArray);
    }

    private void quickSort(char[] charArray, int left, int right) {
        if (left >= right) {
            return;
        }

        // [left..right]
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(charArray, left, randomIndex);

        int pivot = charArray[left];

        int lt = left + 1; // lt: less than
        int gt = right; // ge: greater than
        // all in nums[left + 1..lt) < pivot
        // all in nums[lt..i) = pivot
        // all in nums(gt..right] > pivot
        int i = left + 1;

        while (i <= gt) {
            if (freq[charArray[i]] > freq[pivot]) {
                swap(charArray, i, lt);
                lt++;
                i++;
            } else if (charArray[i] == pivot) {
                i++;
            } else {
                // nums[i] > pivot
                swap(charArray, i, gt);
                gt--;
            }
        }

        swap(charArray, left, lt - 1);

        quickSort(charArray, left, lt - 2);
        quickSort(charArray, gt + 1, right);
    }



    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }



    public String frequencySort2(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        Comparator<Character> comparator = (o1, o2) -> {
            if (map.get(o2) - map.get(o1) == 0) {
                // 要注意：如果出现频次相同，要按字母顺序排序， "loveleetcode" 就是一个很好的测试用例
                return o1.compareTo(o2);
            }
            // 注意顺序
            return map.get(o2) - map.get(o1);
        };
        Character[] cArr = new Character[len];
        for (int i = 0; i < len; i++) {
            cArr[i] = s.charAt(i);
        }
        Arrays.sort(cArr, comparator);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(cArr[i]);
        }
        return stringBuilder.toString();
    }
}
