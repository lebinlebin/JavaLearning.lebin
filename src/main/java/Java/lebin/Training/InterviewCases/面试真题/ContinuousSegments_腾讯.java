package Java.lebin.Training.InterviewCases.面试真题;
/*
一个数组[1,2,3,4,1,2,3,1,2,1,2,3],求这个数字shuffle后，能组成的连续数字片段的个数，连续片段一定是从1开始的。
 */
import java.util.*;

public class ContinuousSegments_腾讯 {

    public static int[] shuffleArray(int[] originalArray) {
        int[] shuffledArray = Arrays.copyOf(originalArray, originalArray.length);
        Random random = new Random();
        for (int i = shuffledArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(shuffledArray, i, j);
        }
        return shuffledArray; // 返回新的打乱后的数组副本
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        // 示例数组，包含从1开始的连续整数，但已被打乱
        int[] array = {1, 2, 3, 4, 1, 2, 3, 1, 2, 1, 2, 3};
//        Restored sequence: [  1]

        array = shuffleArray(array);
        System.out.println(Arrays.toString(array));
        int[] sequence = {4, 2, 1, 3, 5, 4, 6, 7, 2, 3, 1, 5, 6, 8, 9, 7, 10};
        //[1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10]
        //[1, 2, 3, 4, 5, 6, 7]就两个序列
        // 还原序列
        int[] restoredSequence = restoreSequence(array);
        // 输出还原后的序列
        if (restoredSequence != null) {
            System.out.println("Restored sequence: " + Arrays.toString(restoredSequence));
        } else {
            System.out.println("The sequence cannot be restored as it does not start from 1 or has gaps.");
        }
    }

    public static int[] restoreSequence(int[] sequence) {
        // 首先对数组进行排序
        Arrays.sort(sequence);//nlogn
        System.out.println("---------------sequence--------------");
        System.out.println(Arrays.toString(sequence));

        // 创建一个数组来存储每个数字的出现次数
        int[] counts = new int[sequence[sequence.length - 1] + 1];

        // 遍历排序后的数组，统计每个数字的出现次数
        for (int num : sequence) {//n
            counts[num]++;
        }
        System.out.println("--------------------counts---------------------");
        System.out.println(Arrays.toString(counts));

        // 创建一个列表来存储还原后的序列
        java.util.List<Integer> restoredList = new java.util.ArrayList<>();

        // 从1开始遍历，根据出现次数还原序列 从后向前
        int currentNum = sequence[sequence.length - 1];
        System.out.println(currentNum);
        while (currentNum > 0 && counts[currentNum] >= 0) {
            // 如果当前数字的出现次数大于0，则将其添加到还原后的序列中，所有出现次数-1
                for (int i = 1; i <= currentNum; i++) {
                    restoredList.add(i);
                    counts[i]--;
                }
            System.out.println("currentNum:"+ currentNum);
            System.out.println(Arrays.toString(counts));
            // 如果当前currentNum的 count为0则移动到下一个数字
            while(currentNum > 0 && counts[currentNum] == 0){
                currentNum--;
            }
        }
            // 将列表转换为数组并返回
            return restoredList.stream().mapToInt(Integer::intValue).toArray();
    }

}
