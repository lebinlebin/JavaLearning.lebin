package Java.lebin.Training.InterviewCases.各种k个数;

import java.util.ArrayList;
import java.util.List;

/*
无序数组找出所有K, K代表比所有左边大比所有右边小的元素?
规定O(n)时间复杂度 测试用例是:[2,3,1,8,9,20,12] 输出是:[8,9] (也不知道当时是怎么想的一直书出[9,8]。。。。。。。)
其实这题就是lc接雨水的变种题(感谢 生而很菜我很抱歉 的提醒)

1.问题描述
给定一个无序数组，找出比左边大比右边小的所有元素。

输入输出示例：

[1,2,3,1,4,5,7,6] 输出 [4,5]
[1,2,3,1,4,0,4,5] 输出 [5]
[1,2,3,4,5,6,7] 输出 [1,2,3,4,5,6,7]
2.难度级别
middle
 */
/*
4.解题思路
一个数要比它左边的所有数要大，比右边的所有数要小，那么它必定大于左边元素的最大值，同时小于右边元素的最小值。
两次遍历。第一次遍历从后向前，找出第 i 个元素右边元素的最小值，保存在 rightMin 数组中。第二次遍历，从前向后，使用一个临时变量保存左边元素的最大值，一边判断一边更新。
时间复杂度：
两次遍历，所以是 O(2n)。
空间复杂度：
一个是保存右边的最小值数组，一个是临时变量保存左边元素的最大值，还有一个保存满足条件的元素的数组，最长情况下为 n，所以空间复杂度是 O(2n+1)。
 */
public class 无序数组找出所有K_K代表比左边大比右边小的元素 {
    public static  int[] findElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] rightMin = new int[nums.length];
        int min = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; --i) {
            rightMin[i] = min;
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                if(nums[i] < rightMin[i]) {
                    list.add(i);
                }
            }
        }

        return list.stream().parallel().mapToInt(Integer::intValue).toArray();
    }
    /*
    核心思路
    解答1中的思路是第一次遍历的时候把右边的最小值存下来。其实可以不保存，直接正反遍历两次选出符合要求的元素即可。
    题目的要求可以看作两个条件：
    1. 该元素比放在它左边的所有元素都大；
    2. 该元素比放在它右边的所有元素都小。
    第一次遍历先筛选出符合条件1的元素。正向遍历，判断一个元素是否大于其左边所有元素的最大值，把满足条件的保存在 list 中。
    第二次遍历，就找出不满足条件2，但是满足条件1的，把这个元素从 list 中移出去。
    两次遍历之后，list 中剩下的就是既符合条件1，又符合条件2的元素了。
     */
    public int[] findElements2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                list.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] >= min && list.contains(i)) {
                list.remove(i);
            } else {
                min = nums[i];
            }
        }

        return list.stream().parallel().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 2, 4, 5};
//        int[] arr = new int[]{1, 1, 1, 1, 1};
//        int[] arr = new int[]{};
//        int[] arr = new int[]{5, 4, 3, 2, 1};
        int[] arr = new int[]{1, 1, 2, 3, 4};
        int[] result = findElements(arr);
        for (int a : result) {
            System.out.printf("%d ", a);
        }
    }

}
