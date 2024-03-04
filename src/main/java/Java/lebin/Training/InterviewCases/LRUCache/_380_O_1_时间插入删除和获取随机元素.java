package Java.lebin.Training.InterviewCases.LRUCache;

import java.util.*;

/*
时间复杂度：初始化和各项操作的时间复杂度都是 O(1)
空间复杂度：O(n)，其中 n 是集合中的元素个数。存储元素的数组和哈希表需要 O(n) 的空间。
 */
//class RandomizedSet
/*
为了满足插入、删除和获取随机元素操作的时间复杂度都是 O(1)，需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。

 */
public class _380_O_1_时间插入删除和获取随机元素 {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public _380_O_1_时间插入删除和获取随机元素() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
