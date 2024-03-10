package Java.lebin.Training.InterviewCases.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
示例 1：
输入：nums = [1,2,0]
输出：3
解释：范围 [1,2] 中的数字都在数组中。
示例 2：
输入：nums = [3,4,-1,1]
输出：2
解释：1 在数组中，但 2 没有。
示例 3：
输入：nums = [7,8,9,11,12]
输出：1
解释：最小的正数 1 没有出现。
 */
public class _41_缺失的第一个正数 {
    //一句话题解：
    //本题的难点在：只能使用常数级别的额外空间，在这个限制下本题的思路有一个非正式的名称：原地哈希。
    /*
    方法一：哈希表（空间复杂度不符合要求）
    按照刚才我们读例子的思路，其实我们只需从最小的正整数1 开始，依次判断2、3、4 直到数组的长度 N 是否在数组中；
    如果当前考虑的数不在这个数组中，我们就找到了这个缺失的最小正整数；
    由于我们需要依次判断某一个正整数是否在这个数组里，我们可以先把这个数组中所有的元素放进哈希表。接下来再遍历的时候，就可以以
    O(1) 的时间复杂度判断某个正整数是否在这个数组；
    由于题目要求我们只能使用常数级别的空间，而哈希表的大小与数组的长度是线性相关的，因此空间复杂度不符合题目要求。
     */
    /*
    时间复杂度： O(N)，这里 N 表示数组的长度。第 1 次遍历了数组，第 2 次遍历了区间 [1, len] 里的元素。
    空间复杂度：O(N)，把 N 个数存在哈希表里面，使用了 N 个空间。
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }
    /*
    方法二：二分查找（时间复杂度不符合要求）
    根据刚才的分析，这个问题其实就是要我们查找一个元素，而查找一个元素，如果是在有序数组中查找，会快一些；
    因此我们可以将数组先排序，再使用二分查找法从最小的正整数 1 开始查找，找不到就返回这个正整数；
    这个思路需要先对数组排序，而排序使用的时间复杂度是 O(NlogN)，是不符合这个问题的时间复杂度要求。
     */
    /*
    复杂度分析：
    时间复杂度：O(NlogN)。时间复杂度主要消耗在排序上，排序使用 O(NlogN)。
    二分查找使用每一步使用的时间复杂度是 O(logN)，整体上仍然是 O(NlogN)；
    空间复杂度：O(1)。
     */
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i <= len; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }
        return len + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    /*
    方法三：将数组视为哈希表  原地哈希（哈希函数为：f(nums[i]) = nums[i] - 1）。
    思路来自剑指 Offer 03. 数组中重复的数字。下面简要叙述：
    由于题目要求我们「只能使用常数级别的空间」，而要找的数一定在 [1, N + 1] 左闭右闭（这里 N 是数组的长度）这个区间里。
    因此，我们可以就把原始的数组当做哈希表来使用。事实上，哈希表其实本身也是一个数组；
    我们要找的数就在 [1, N + 1] 里，最后 N + 1 这个元素我们不用找。因为在前面的 N 个元素都找不到的情况下，我们才返回 N + 1；
    那么，我们可以采取这样的思路：就把 1 这个数放到下标为 0 的位置， 2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。
    然后我们再遍历一次数组，第 1 个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数。
    这个思想就相当于我们自己编写哈希函数，这个哈希函数的规则特别简单，那就是数值为 i 的数映射到下标为 i - 1 的位置。
     */
    //注意：理解下面代码 nums[nums[i] - 1] != nums[i] 的作用。
    //时间复杂度：O(N)，这里N 是数组的长度。
    //空间复杂度：O(1)。
    public int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            /**对nums[nums[i] - 1] != nums[i]这句代码的理解
             * 我们的hash函数  数值为 i 的数映射到下标为 i - 1 的位置
             * 那么, nums[i]上边放的数就是 i+1, 也就是 nums[i]==i+1 成立，同理 nums[i-1]==i
             * 那么如果都是按照这个hash映射整理好的数组的话，
             * 由nums[i]==i+1 ==> 就存在  nums[i] == nums[nums[i]-1]
             */
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
