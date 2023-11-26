package Java.lebin.Training.InterviewCases.SortArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 示例 1：
 输入：nums = [3,4,3,3]
 输出：4
 示例 2：
 */
/*
使用HashMap
使用HashMap的原理是统计每个数字出现的次数，因为只有一个数字出现一次，其他都出现3次，我们只需要返回那个出现一次的即可，原理比较简单，
时间复杂度：O(n)，其中 n是数组长度。只需要对数组遍历一次。
空间复杂度：O(1)
 */
public class _136_剑指56_II_数组中数字出现的次数II_136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //先把数字存储到map中，其中key存储的是当前数字，value是
        //数字的出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //最后在遍历map中的所有元素，返回value值等于1的
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
}
